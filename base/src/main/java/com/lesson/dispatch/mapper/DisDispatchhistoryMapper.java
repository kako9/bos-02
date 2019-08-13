package com.lesson.dispatch.mapper;

import com.lesson.dispatch.entity.DisDispatchhistory;
import com.lesson.dispatch.entity.DisDispatchhistoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DisDispatchhistoryMapper {
    long countByExample(DisDispatchhistoryExample example);

    int deleteByExample(DisDispatchhistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DisDispatchhistory record);

    int insertSelective(DisDispatchhistory record);

    List<DisDispatchhistory> selectByExample(DisDispatchhistoryExample example);

    DisDispatchhistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DisDispatchhistory record, @Param("example") DisDispatchhistoryExample example);

    int updateByExample(@Param("record") DisDispatchhistory record, @Param("example") DisDispatchhistoryExample example);

    int updateByPrimaryKeySelective(DisDispatchhistory record);

    int updateByPrimaryKey(DisDispatchhistory record);
}