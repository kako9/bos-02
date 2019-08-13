package com.lesson.sys.util;

import com.lesson.sys.entity.SysDept;

import java.util.*;

public class SysDeptGroupUtil {

    /**
     * 获得一级部门
     * @param list
     * @return
     */
    public List<SysDept> getFirstDept(List<SysDept> list){
        List<SysDept> firstDept= new ArrayList<>();

        for (SysDept dept:list){
            if(dept.getParentId().longValue()==0){
                dept.setChildren(getChildrenDept(dept.getId(),list));
                firstDept.add(dept);
            }
        }
        return  firstDept;
    }

    /**
     * 递归获得子集
     * @param parentId
     * @param list
     * @return
     */
    public List<SysDept> getChildrenDept(Long parentId,List<SysDept> list){
        List<SysDept> childrenDept = new ArrayList<>();
        for (SysDept dept:list){
            if(dept.getParentId().longValue()==0){
                continue;
            }
            if(dept.getParentId().longValue()==parentId){
                dept.setChildren(getChildrenDept(dept.getId(),list));
                childrenDept.add(dept);
            }
        }
        return childrenDept;
    }

}
