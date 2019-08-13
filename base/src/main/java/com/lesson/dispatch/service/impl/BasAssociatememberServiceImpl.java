package com.lesson.dispatch.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.lesson.dispatch.entity.BasAssociatemember;
import com.lesson.dispatch.entity.BasAssociatememberExample;
import com.lesson.dispatch.mapper.BasAssociatememberMapper;
import com.lesson.dispatch.service.BasAssociatememberService;
import com.lesson.sys.config.AliyunConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BasAssociatememberServiceImpl implements BasAssociatememberService {

    @Autowired
    private BasAssociatememberMapper basAssociatememberMapper;

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<BasAssociatemember> basAssociatememberList() {
        return basAssociatememberMapper.selectByExample(null);
    }

    /**
     * 转单给小件员成功，下发短信
     * @param empno
     * @return
     */
    @Override
    public Map<String, Object> transferSmallPart(String empno) {
        BasAssociatememberExample example = new BasAssociatememberExample();
        BasAssociatememberExample.Criteria criteria = example.createCriteria();
        criteria.andEmpnoEqualTo(empno);
        List<BasAssociatemember> list = basAssociatememberMapper.selectByExample(example);
        BasAssociatemember basAssociatemember = list.get(0);
        Map<String, Object> map = new HashMap<>();
        try {
            AliyunConfig.sendSms(basAssociatemember.getPhone());
            //map.put("code", 200);
            map.put("msg", "短信验证发送成功");
            return map;
        } catch (ClientException e) {
            //map.put("code", 300);
            map.put("msg","短信发送失败");
            return map;
        }
    }

    /**
     * 重发
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> retry(Integer id) {
        BasAssociatemember basAssociatemember = basAssociatememberMapper.selectByPrimaryKey(id);
        Map<String, Object> map = new HashMap<>();
        try {
            AliyunConfig.sendSms(basAssociatemember.getPhone());
            //map.put("code", 200);
            map.put("msg", "短信验证发送成功");
            return map;
        } catch (ClientException e) {
            //map.put("code", 300);
            map.put("msg","短信发送失败");
            return map;
        }
    }
}
