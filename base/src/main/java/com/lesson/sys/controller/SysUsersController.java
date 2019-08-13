package com.lesson.sys.controller;

import com.lesson.sys.entity.SysUser;
import com.lesson.sys.service.SysUserService;
import com.lesson.sys.util.ResponseResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("users")
public class SysUsersController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 登出
     * @return
     */
    @RequestMapping("logout")
    public ResponseResult logout(){
        ResponseResult result = new ResponseResult();
        Subject subject = SecurityUtils.getSubject();
        // 只需调用shiro的logout方法就可以了
        subject.logout();
        return result;
    }

    /**
     * 查询用户对应的角色
     * @param token
     * @return
     */
    @RequestMapping("info")
    public ResponseResult info(String token){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        ResponseResult result = new ResponseResult();
        if(token.equals(subject.getSession().getId().toString())){
            // 从shiro的session里获得保存的用户信息
            SysUser loginUser = (SysUser) session.getAttribute("USER_SESSION");
            // 获得角色字符串集合
            List<String> roles = (List<String>) session.getAttribute("roles");
            if(loginUser!=null){
                // 根据用户获得角色字符串数组
                roles = sysUserService.findUserRoles(loginUser.getUsername());
                result.getData().put("roles",roles);
                result.getData().put("introduction",loginUser.getIntroduction());
                result.getData().put("avatar",loginUser.getAvatar());
                result.getData().put("name",loginUser.getUsername());
                return result;
            }
        }
        return null;
    }

    /**
     * 用户登录
     * @param sysUser
     * @param session
     * @return
     */
    @PostMapping("login")
    public ResponseResult login(SysUser sysUser, HttpSession session){
        ResponseResult result = new ResponseResult();

        UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getUsername(), sysUser.getPassword());
        // 获得登录的主题
        Subject subject = SecurityUtils.getSubject();
        // 调用登录方法
        subject.login(token);
        // 返回给前台的toke，唯一标识用户
        result.getData().put("token",subject.getSession().getId());
        session.setAttribute("loginUser",sysUser);
        return result;
    }

    /**
     * 查询所有用户
     * @return
     */
    @PostMapping("userList")
    @RequiresPermissions("users:userList")
    public ResponseResult userList(Integer curPage,Integer pageSize){
      // Map<String,Object> map = sysUserService.userList(1,8);
        Map<String,Object> map = sysUserService.userList(curPage,pageSize);
        ResponseResult result = new ResponseResult();
        result.getData().put("list",map.get("page"));
        result.getData().put("total",map.get("total"));
        return result;
    }

    /**
     * 删除用户
     * @return
     */
    @PostMapping("deleteUser")
    @RequiresPermissions("users:delete")
    public ResponseResult deleteUser(Integer id){
        sysUserService.deleteUser(id);
        ResponseResult result = new ResponseResult();
        result.getData().put("message","删除成功");
        return result;
    }

    /**
     * 添加用户
     * @return
     */
    @PostMapping("addUser")
    @RequiresPermissions("users:add")
    public ResponseResult addUser( SysUser sysUser, HttpSession session){
        sysUser.setStatus(new Byte("1"));
        sysUser.setDelFlag(new Byte("0"));
        SysUser user = (SysUser) session.getAttribute("loginUser");
        sysUser.setCreateBy(user.getUsername());
        sysUser.setCreateTime(new Date());
        sysUser.setLastUpdateBy(user.getUsername());
        sysUser.setLastUpdateTime(new Date());

        //生成盐（部分，需要存入数据库中）
        String salt=new SecureRandomNumberGenerator().nextBytes().toHex();
        //将原始密码加盐（上面生成的盐），并且用md5算法加密两次，将最后结果存入数据库中
        String password = new Md5Hash(sysUser.getPassword(),salt,6).toString();
        sysUser.setSalt(salt);
        sysUser.setPassword(password);

        sysUserService.addUser(sysUser);
        ResponseResult result = new ResponseResult();
        result.getData().put("message","添加成功");
        return result;
    }
    /**
     * 修改用户
     * @return
     */
    @PostMapping("updateUser")
    @RequiresPermissions("users:update")
    public ResponseResult updateUser( SysUser sysUser,HttpSession session){
        SysUser user = (SysUser) session.getAttribute("loginUser");
        sysUser.setLastUpdateBy(user.getUsername());
        sysUser.setLastUpdateTime(new Date());

        //生成盐（部分，需要存入数据库中）
        String salt=new SecureRandomNumberGenerator().nextBytes().toHex();
        //将原始密码加盐（上面生成的盐），并且用md5算法加密两次，将最后结果存入数据库中
        String password = new Md5Hash(sysUser.getPassword(),salt,2).toString();
        sysUser.setSalt(salt);
        sysUser.setPassword(password);

        sysUserService.updateUser(sysUser);
        ResponseResult result = new ResponseResult();
        result.getData().put("message","修改成功");
        return result;
    }

    /**
     * 根据id查询用户信息
     * @return
     */
    @PostMapping("getById")
    public ResponseResult getById( Integer id){
        SysUser sysUser = sysUserService.getById(id);
        ResponseResult result = new ResponseResult();
        result.getData().put("sysUser",sysUser);
        return result;
    }

    /**
     * 根据名字模糊查询
     * @param ByName
     * @return
     */
    @PostMapping("getByName")
    public ResponseResult getByName(String ByName,Integer curPage,Integer pageSize){
        Map<String,Object> map = sysUserService.getByName(curPage,pageSize,ByName);
        ResponseResult result = new ResponseResult();
        result.getData().put("list",map.get("page"));
        result.getData().put("total",map.get("total"));
        return result;
    }

    /**
     * 查询对应用户所有的角色id
     * @param userId
     * @return
     */
    @PostMapping("roleList")
    public ResponseResult roleList(Long userId){
        ResponseResult result = new ResponseResult();
        result.getData().put("roleList",sysUserService.getUserRoleId(userId));
        return result;
    }
}
