package com.lesson.dispatch.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lesson.dispatch.entity.AccBusinessadmissibility;
import com.lesson.dispatch.mapper.AccBusinessadmissibilityMapper;
import com.lesson.dispatch.service.AccBusinessAdmissibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccBusinessAdmissibilityServiceImpl implements AccBusinessAdmissibilityService {

    @Autowired
    private AccBusinessadmissibilityMapper accBusinessadmissibilityMapper;

    /**
     * 查询所有业务受理
     * @param curPage
     * @param pageSize
     * @return
     */
    @Override
    public Map<String, Object> queryAccBusinessadmissibilityAndAccWorkorder(Integer curPage, Integer pageSize) {
        PageHelper pageHelper = new PageHelper();
        Page page = pageHelper.startPage(curPage,pageSize,true);
        List<AccBusinessadmissibility> list = accBusinessadmissibilityMapper.queryAccBusinessadmissibilityAndAccWorkorder();
        Map<String,Object> map = new HashMap<>();
        map.put("page", page.getResult());
        map.put("total", page.getTotal());
        return map;
    }

    /**
     * 根据条件查询业务通知单对应的工单表
     */
    @Override
    public Map<String, Object> queryAccBusinessadmissibilityAndAccWorkorderCondition(Integer curPage,Integer pageSize,AccBusinessadmissibility accBusinessadmissibility) {
        PageHelper pageHelper = new PageHelper();
        Page page = pageHelper.startPage(curPage,pageSize,true);
        List<AccBusinessadmissibility> list = accBusinessadmissibilityMapper.queryAccBusinessadmissibilityAndAccWorkorderCondition(accBusinessadmissibility);
        Map<String,Object> map = new HashMap<>();
        map.put("page", page.getResult());
        map.put("total", page.getTotal());
        return map;
    }

    /**
     * 修改业务受理
     * @param accBusinessadmissibility
     */
    @Override
    public void updateAccBusinessadmissibility(AccBusinessadmissibility accBusinessadmissibility) {
        accBusinessadmissibilityMapper.updateByPrimaryKeySelective(accBusinessadmissibility);
    }

}
