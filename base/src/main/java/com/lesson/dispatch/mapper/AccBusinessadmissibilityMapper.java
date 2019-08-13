package com.lesson.dispatch.mapper;

import com.lesson.dispatch.entity.AccBusinessadmissibility;
import com.lesson.dispatch.entity.AccBusinessadmissibilityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccBusinessadmissibilityMapper {

    /**
     * 查询业务通知单对应的工单表
     */
    public List<AccBusinessadmissibility> queryAccBusinessadmissibilityAndAccWorkorder();

    /**
     * 根据条件查询业务通知单对应的工单表
     */
    public List<AccBusinessadmissibility> queryAccBusinessadmissibilityAndAccWorkorderCondition(AccBusinessadmissibility accBusinessadmissibility);

    long countByExample(AccBusinessadmissibilityExample example);

    int deleteByExample(AccBusinessadmissibilityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AccBusinessadmissibility record);

    int insertSelective(AccBusinessadmissibility record);

    List<AccBusinessadmissibility> selectByExample(AccBusinessadmissibilityExample example);

    AccBusinessadmissibility selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AccBusinessadmissibility record, @Param("example") AccBusinessadmissibilityExample example);

    int updateByExample(@Param("record") AccBusinessadmissibility record, @Param("example") AccBusinessadmissibilityExample example);

    int updateByPrimaryKeySelective(AccBusinessadmissibility record);

    int updateByPrimaryKey(AccBusinessadmissibility record);
}