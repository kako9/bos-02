package com.lesson.Return.mapper;

import com.lesson.Return.entity.IaeArrival;
import com.lesson.Return.entity.IaeArrivalExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IaeArrivalMapper {
    long countByExample(IaeArrivalExample example);

    int deleteByExample(IaeArrivalExample example);

    int deleteByPrimaryKey(String id);

    int insert(IaeArrival record);

    int insertSelective(IaeArrival record);

    List<IaeArrival> selectByExample(IaeArrivalExample example);

    IaeArrival selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") IaeArrival record, @Param("example") IaeArrivalExample example);

    int updateByExample(@Param("record") IaeArrival record, @Param("example") IaeArrivalExample example);

    int updateByPrimaryKeySelective(IaeArrival record);

    int updateByPrimaryKey(IaeArrival record);
}