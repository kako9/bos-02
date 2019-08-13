package com.lesson.dispatch.mapper;

import com.lesson.dispatch.entity.DisPropagandatask;
import com.lesson.dispatch.entity.DisPropagandataskExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DisPropagandataskMapper {
    long countByExample(DisPropagandataskExample example);

    int deleteByExample(DisPropagandataskExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DisPropagandatask record);

    int insertSelective(DisPropagandatask record);

    List<DisPropagandatask> selectByExample(DisPropagandataskExample example);

    DisPropagandatask selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DisPropagandatask record, @Param("example") DisPropagandataskExample example);

    int updateByExample(@Param("record") DisPropagandatask record, @Param("example") DisPropagandataskExample example);

    int updateByPrimaryKeySelective(DisPropagandatask record);

    int updateByPrimaryKey(DisPropagandatask record);
}