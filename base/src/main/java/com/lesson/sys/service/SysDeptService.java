package com.lesson.sys.service;


import com.lesson.sys.entity.SysDept;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface SysDeptService {

    /**
     * 查询所有部门
     * @return
     */
    public List<SysDept> dpetList();

    /**
     * 修改部门
     * @param sysDept
     */
    public void updateDept (SysDept sysDept);

    /**
     * `删除部门
     * @param id
     */
    public void deleteDept(Long id);

    /**
     * 添加部门
     * @param sysDept
     * @return
     */
    public Serializable addDept(SysDept sysDept);

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    public SysDept getById(Long id);

    /**
     * 查询所有部门
     * @return
     */
    public Map<String,Object> getList(Integer curPage, Integer pageSize);

    /**
     * 根据部门名模糊查询
     * @param name
     * @param curPage
     * @param pageSize
     * @return
     */
    public Map<String,Object> getByName(String name,Integer curPage, Integer pageSize);

    /**
     * 根据上级部门id查询
     * @param parentId
     * @return
     */
    public List<SysDept> getParentId(Integer parentId);

    /**
     * 根据登录的用户的部门查询下级部门
     * @param parentId
     * @return
     */
    public List<SysDept> getByParentID(Long parentId);
}
