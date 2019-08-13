package com.lesson.dispatch.service;

import com.lesson.dispatch.entity.BasZoneInfo;

import java.util.List;
import java.util.Map;

public interface BasZoneInfoService {

    public List<BasZoneInfo> basZoneInfoList();

    /**
     * 给定转单成功，下发短信
     * @return
     */
    public Map<String, Object> transferSms(String zonecode);
}
