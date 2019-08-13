package com.lesson.dispatch.mapper;

import com.lesson.dispatch.entity.DisWorkordersign;
import com.lesson.dispatch.entity.DisWorkordersignExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DisWorkordersignMapper {

    /**
     * 查询所有工作单签收信息
     * @return
     */
    public List<DisWorkordersign> disWorkordersignAndSysUserAndSysDept();

    /**
     * 根据条件查询工作单签收信息
     * @return
     */
    public List<DisWorkordersign> conditionDisWorkordersignAndSysUserAndSysDept(DisWorkordersign disWorkordersign);

    long countByExample(DisWorkordersignExample example);

    int deleteByExample(DisWorkordersignExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DisWorkordersign record);

    int insertSelective(DisWorkordersign record);

    List<DisWorkordersign> selectByExample(DisWorkordersignExample example);

    DisWorkordersign selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DisWorkordersign record, @Param("example") DisWorkordersignExample example);

    int updateByExample(@Param("record") DisWorkordersign record, @Param("example") DisWorkordersignExample example);

    int updateByPrimaryKeySelective(DisWorkordersign record);

    int updateByPrimaryKey(DisWorkordersign record);
}