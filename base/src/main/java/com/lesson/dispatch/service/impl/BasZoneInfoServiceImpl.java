package com.lesson.dispatch.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.lesson.dispatch.entity.BasZoneInfo;
import com.lesson.dispatch.entity.BasZoneInfoExample;
import com.lesson.dispatch.mapper.BasZoneInfoMapper;
import com.lesson.dispatch.service.BasZoneInfoService;
import com.lesson.sys.config.AliyunConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BasZoneInfoServiceImpl implements BasZoneInfoService {

    @Autowired
    private BasZoneInfoMapper basZoneInfoMapper;

    @Override
    public List<BasZoneInfo> basZoneInfoList() {
        return basZoneInfoMapper.selectByExample(null);
    }

    /*
     * 转单成功 下发短信
     * @param zonecode
     * @return*/
    @Override
    public Map<String, Object> transferSms(String zonecode) {
        BasZoneInfoExample example = new BasZoneInfoExample();
        BasZoneInfoExample.Criteria criteria = example.createCriteria();
        criteria.andZonecodeEqualTo(zonecode);
        List<BasZoneInfo> list = basZoneInfoMapper.selectByExample(example);
        BasZoneInfo basZoneInfo = list.get(0);
        Map<String, Object> map = new HashMap<>();
        try {
            AliyunConfig.sendSms(basZoneInfo.getTelphone());
           // map.put("code", 200);
            map.put("msg", "短信验证发送成功");
            return map;
        } catch (ClientException e) {
           // map.put("code", 300);
            map.put("msg", "短信发送失败");
            return map;
        }
    }
}
