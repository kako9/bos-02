package com.lesson.Return.service.impl;

import com.lesson.Return.entity.IaeArrival;
import com.lesson.Return.mapper.IaeArrivalMapper;
import com.lesson.Return.service.IaeArrivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IaeArrivalServiceImpl implements IaeArrivalService {

    @Autowired
    private IaeArrivalMapper iaeArrivalMapper;

    /**
     * 根据工作单号查询对应信息
     * @param id
     * @return
     */
    @Override
    public IaeArrival getById(String id) {
        return iaeArrivalMapper.selectByPrimaryKey(id);
    }
}
