package com.lesson.Return.mapper;

import com.lesson.Return.entity.RetReturnList;
import com.lesson.Return.entity.RetReturnListExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RetReturnListMapper {

    /**
     * 查询所有签收单和对应的部门
     * @return
     */
    public List<RetReturnList> retReturnListAndDeptList();

    /**
     * 根据条件查询签收单和对应的部门
     * @param retReturnList
     * @return
     */
    public List<RetReturnList> getRetReturnListAndDeptListTerm(RetReturnList retReturnList);

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