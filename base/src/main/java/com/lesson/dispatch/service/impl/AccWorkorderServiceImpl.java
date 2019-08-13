package com.lesson.dispatch.service.impl;

import com.lesson.dispatch.entity.AccWorkorder;
import com.lesson.dispatch.mapper.AccWorkorderMapper;
import com.lesson.dispatch.service.AccWorkorderService;
import com.lesson.sys.entity.SysDept;
import com.lesson.sys.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccWorkorderServiceImpl implements AccWorkorderService {

    @Autowired
    private AccWorkorderMapper accWorkorderMapper;

    @Autowired
    private SysDeptMapper sysDeptMapper;
    /**
     * 根据id销单
     * @param id
     */
    @Override
    public void deleteAccWorkorder(Integer id) {
        accWorkorderMapper.deleteByPrimaryKey(id);
    }

    /**
     * 新增工作单
     * @param accWorkorder
     */
    @Override
    public void addAccWorkorder(AccWorkorder accWorkorder) {
        accWorkorderMapper.insert(accWorkorder);
    }

    /**
     * 根据工单号删除工单信息
     * @param jobno
     */
    @Override
    public void updateAccWorkorder(AccWorkorder accWorkorder) {
        accWorkorder.setJobtype(3);
        accWorkorderMapper.updateByPrimaryKeySelective(accWorkorder);
    }

    /**
     * 退回
     * @param accWorkorder
     */
    @Override
    public void sendBack(AccWorkorder accWorkorder) {
        SysDept sysDept = sysDeptMapper.selectByPrimaryKey(new Long(accWorkorder.getPickupunit()) );
        accWorkorder.setPickupunit(sysDept.getParentId().intValue());
        accWorkorderMapper.updateByPrimaryKeySelective(accWorkorder);
    }

    /**
     * 分配
     * @param accWorkorder
     */
    @Override
    public void allocation(AccWorkorder accWorkorder) {
        accWorkorderMapper.updateByPrimaryKeySelective(accWorkorder);
    }
}
