package com.lesson.dispatch.controller;

import com.lesson.dispatch.entity.BasZoneInfo;
import com.lesson.dispatch.service.BasZoneInfoService;
import com.lesson.dispatch.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("zoneInfo")
public class BasZoneInfoController {

   @Autowired
    private BasZoneInfoService basZoneInfoService;

    /**
     * 查询所有定区信息
     * @return
     */
    @PostMapping("basZoneInfoList")
    public ResponseResult basZoneInfoList(){
        List<BasZoneInfo> list = basZoneInfoService.basZoneInfoList();
        ResponseResult result = new ResponseResult();
        result.getData().put("basZoneInfoList",list);
        return result;
    }

    /**
     * 转单成功，下发短信
     * @param zonecode
     * @return
     */
    @PostMapping("transferSms")
    public ResponseResult transferSms(String zonecode){
        Map<String,Object> map = new HashMap<>();
        map.put("message",basZoneInfoService.transferSms(zonecode));
        ResponseResult result = new ResponseResult();
        result.setMessage(map.get("message").toString());
        return result;
    }
}
