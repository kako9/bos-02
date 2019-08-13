package com.lesson.dispatch.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lesson.dispatch.entity.DisWorkordersign;
import com.lesson.dispatch.mapper.DisWorkordersignMapper;
import com.lesson.dispatch.service.DisWorkOrderSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DisWorkOrderSignServiceImpl implements DisWorkOrderSignService {

    @Autowired
   private DisWorkordersignMapper disWorkordersignMapper;

    /**
     * 查询所有工作单签收
     * @param curPage
     * @param pageSize
     * @return
     */
    @Override
    public Map<String, Object> disWorkordersignList(Integer curPage, Integer pageSize) {
        PageHelper pageHelper = new PageHelper();
        Page page = pageHelper.startPage(curPage,pageSize,true);
        List<DisWorkordersign> list = disWorkordersignMapper.disWorkordersignAndSysUserAndSysDept();
        Map<String,Object> map = new HashMap<>();
        map.put("page", page.getResult());
        map.put("total", page.getTotal());
        return map;
    }

    @Override
    public void addDisWorkordersign(DisWorkordersign disWorkordersign) {
        disWorkordersignMapper.insert(disWorkordersign);
    }

    @Override
    public void updateDisWorkordersign(DisWorkordersign disWorkordersign) {
        disWorkordersignMapper.updateByPrimaryKeySelective(disWorkordersign);
    }

    @Override
    public Map<String, Object> conditionDisWorkordersignList(Integer curPage, Integer pageSize, DisWorkordersign disWorkordersign) {
        PageHelper pageHelper = new PageHelper();
        Page page = pageHelper.startPage(curPage,pageSize,true);
        List<DisWorkordersign> list = disWorkordersignMapper.conditionDisWorkordersignAndSysUserAndSysDept(disWorkordersign);
        Map<String,Object> map = new HashMap<>();
        map.put("page", page.getResult());
        map.put("total", page.getTotal());
        return map;
    }
}
