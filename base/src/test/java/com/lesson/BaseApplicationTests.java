package com.lesson;

import com.lesson.sys.config.AliyunConfig;
import com.lesson.sys.entity.SysMenu;
import com.lesson.sys.entity.SysRole;
import com.lesson.sys.entity.SysUser;
import com.lesson.sys.mapper.SysUserMapper;
import com.lesson.sys.util.HttpClientUtil;
import com.lesson.sys.util.SmsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseApplicationTests {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void contextLoads() {
        SmsService.send("13297471017","验证码：[634521]");
    }

    /*@Test
    public void aliyun() {
        String phone = "13297471017";
        AliyunConfig.sendSms(phone);
    }*/

    @Test
    public void test(){
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar calendar = Calendar.getInstance();
        String dateName = df.format(calendar.getTime());
        System.out.println(dateName);
    }


    @Test
    public void testFindUserByNameAndRoleAndMenu(){
        List<SysUser> list = sysUserMapper.findUserByNameAndRoleAndMenu("admin");
        for(SysUser user :list){
            System.out.println("用户名"+user.getUsername());
            for(SysRole role : user.getRoleList()){
                System.out.println("\t\t角色"+role.getName());
                for (SysMenu menu :role.getMenuList()){
                    System.out.println("\t\t\t\t权限"+menu.getName());
                }
            }
        }
    }
    //用户名
    private static String Uid = "画里的他";

    //接口安全秘钥
    private static String Key = "d41d8cd98f00b204e980";

    //手机号码，多个号码如13800000000,13800000001,13800000002
    private static String smsMob = "13297471017";
    //短信内容
    private static String smsText = "bos物流提醒你：你有新的订单请注意查收，业务通知单号：YWTZD1001";
    @Test
    public void SMSVerification(){
        HttpClientUtil client = HttpClientUtil.getInstance();

        //UTF发送
        int result = client.sendMsgUtf8(Uid, Key, smsText, smsMob);
        if(result>0){
            System.out.println("UTF8成功发送条数=="+result);
        }else{
            System.out.println(client.getErrorMsg(result));
        }
    }

}
