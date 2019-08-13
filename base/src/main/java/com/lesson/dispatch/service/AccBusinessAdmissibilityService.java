package com.lesson.dispatch.service;

import com.lesson.dispatch.entity.AccBusinessadmissibility;

import java.util.Map;

public interface AccBusinessAdmissibilityService {

    /**
     * 查询所有业务受理
     * @param curPage
     * @param pageSize
     * @return
     */
    public Map<String,Object> queryAccBusinessadmissibilityAndAccWorkorder(Integer curPage, Integer pageSize);

    /**
     * 根据条件查询业务通知单对应的工单表
     */
    public Map<String,Object> queryAccBusinessadmissibilityAndAccWorkorderCondition(Integer curPage,Integer pageSize,AccBusinessadmissibility accBusinessadmissibility);

    /**
     * 修改业务受理
     * @param accBusinessadmissibility
     */
    public void updateAccBusinessadmissibility(AccBusinessadmissibility accBusinessadmissibility);

}
