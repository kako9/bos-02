package com.lesson.dispatch.mapper;

import com.lesson.dispatch.entity.AccWorkorder;
import com.lesson.dispatch.entity.AccWorkorderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccWorkorderMapper {
    long countByExample(AccWorkorderExample example);

    int deleteByExample(AccWorkorderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AccWorkorder record);

    int insertSelective(AccWorkorder record);

    List<AccWorkorder> selectByExample(AccWorkorderExample example);

    AccWorkorder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AccWorkorder record, @Param("example") AccWorkorderExample example);

    int updateByExample(@Param("record") AccWorkorder record, @Param("example") AccWorkorderExample example);

    int updateByPrimaryKeySelective(AccWorkorder record);

    int updateByPrimaryKey(AccWorkorder record);
}