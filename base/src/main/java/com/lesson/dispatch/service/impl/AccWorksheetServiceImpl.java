package com.lesson.dispatch.service.impl;


import com.lesson.dispatch.entity.AccWorkorder;
import com.lesson.dispatch.entity.AccWorksheet;
import com.lesson.dispatch.mapper.AccWorksheetMapper;
import com.lesson.dispatch.service.AccWorksheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccWorksheetServiceImpl implements AccWorksheetService {

    @Autowired
    private AccWorksheetMapper accWorksheetMapper;

    /**
     * 查询所有工作单
     * @return
     */
    @Override
    public List<AccWorksheet> accWorksheetList() {
        return accWorksheetMapper.selectByExample(null);
    }

    /**
     * 根据id查询工作单
     * @param id
     * @return
     */
    @Override
    public AccWorksheet getById(Integer id) {
        return accWorksheetMapper.selectByPrimaryKey(id);
    }
}
