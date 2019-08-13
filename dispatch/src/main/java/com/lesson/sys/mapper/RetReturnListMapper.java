package com.lesson.sys.mapper;

import com.lesson.sys.entity.RetReturnList;
import com.lesson.sys.entity.RetReturnListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetReturnListMapper {
    long countByExample(RetReturnListExample example);

    int deleteByExample(RetReturnListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RetReturnList record);

    int insertSelective(RetReturnList record);

    List<RetReturnList> selectByExample(RetReturnListExample example);

    RetReturnList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RetReturnList record, @Param("example") RetReturnListExample example);

    int updateByExample(@Param("record") RetReturnList record, @Param("example") RetReturnListExample example);

    int updateByPrimaryKeySelective(RetReturnList record);

    int updateByPrimaryKey(RetReturnList record);
}