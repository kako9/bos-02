package com.lesson.dispatch.service;

import com.lesson.dispatch.entity.AccWorkorder;

public interface AccWorkorderService {

    /**
     销单
     */
    public void deleteAccWorkorder(Integer id);

    /**
     * 新增工单
     */
    public void addAccWorkorder(AccWorkorder accWorkorder);

    /**
     * 根据工单号删除
     * @param jobno
     */
    public void updateAccWorkorder(AccWorkorder accWorkorder);

    /**
     * 退回
     * @param jobno
     */
    public void sendBack(AccWorkorder accWorkorder);

    /**
     * 分配
     * @param accWorkorder
     */
    public void allocation(AccWorkorder accWorkorder);
}
