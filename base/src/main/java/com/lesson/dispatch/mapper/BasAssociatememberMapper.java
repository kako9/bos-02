package com.lesson.dispatch.mapper;

import com.lesson.dispatch.entity.BasAssociatemember;
import com.lesson.dispatch.entity.BasAssociatememberExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BasAssociatememberMapper {
    long countByExample(BasAssociatememberExample example);

    int deleteByExample(BasAssociatememberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BasAssociatemember record);

    int insertSelective(BasAssociatemember record);

    List<BasAssociatemember> selectByExample(BasAssociatememberExample example);

    BasAssociatemember selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BasAssociatemember record, @Param("example") BasAssociatememberExample example);

    int updateByExample(@Param("record") BasAssociatemember record, @Param("example") BasAssociatememberExample example);

    int updateByPrimaryKeySelective(BasAssociatemember record);

    int updateByPrimaryKey(BasAssociatemember record);
}