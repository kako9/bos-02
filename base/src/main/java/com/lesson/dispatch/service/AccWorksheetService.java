package com.lesson.dispatch.service;

import com.lesson.dispatch.entity.AccWorksheet;

import java.util.List;

public interface AccWorksheetService {

    /**
     * 查询所有工作单
     * @return
     */
    public List<AccWorksheet> accWorksheetList();

    /**
     * 根据id查询工作单
     * @param id
     * @return
     */
    public AccWorksheet getById(Integer id);
}
