package com.lesson.dispatch.service;

import com.lesson.dispatch.entity.DisWorkordersign;

import java.util.Map;

public interface DisWorkOrderSignService {

    /**
     * 查询所有工作单签收
     * @param curPage
     * @param pageSize
     * @return
     */
    public Map<String, Object> disWorkordersignList(Integer curPage, Integer pageSize);

    /**
     * 添加工作单签收
     * @param disWorkordersign
     */
    public void addDisWorkordersign(DisWorkordersign disWorkordersign);

    /**
     * 修改工作单签收
     * @param disWorkordersign
     */
    public void updateDisWorkordersign(DisWorkordersign disWorkordersign);

    /**
     * 根据条件查询工作单签收
     * @param curPage
     * @param pageSize
     * @param disWorkordersign
     * @return
     */
    public Map<String, Object> conditionDisWorkordersignList(Integer curPage,Integer pageSize,DisWorkordersign disWorkordersign);
}
