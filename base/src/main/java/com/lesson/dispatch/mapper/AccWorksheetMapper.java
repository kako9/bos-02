package com.lesson.dispatch.mapper;

import com.lesson.dispatch.entity.AccWorksheet;
import com.lesson.dispatch.entity.AccWorksheetExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccWorksheetMapper {
    long countByExample(AccWorksheetExample example);

    int deleteByExample(AccWorksheetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AccWorksheet record);

    int insertSelective(AccWorksheet record);

    List<AccWorksheet> selectByExample(AccWorksheetExample example);

    AccWorksheet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AccWorksheet record, @Param("example") AccWorksheetExample example);

    int updateByExample(@Param("record") AccWorksheet record, @Param("example") AccWorksheetExample example);

    int updateByPrimaryKeySelective(AccWorksheet record);

    int updateByPrimaryKey(AccWorksheet record);
}