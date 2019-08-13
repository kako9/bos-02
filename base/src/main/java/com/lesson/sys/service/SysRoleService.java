package com.lesson.sys.service;

import com.lesson.sys.entity.SysRole;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface SysRoleService {

    /**
     * 查询所有角色，用户分页
     * @return
     */
    public Map<String,Object> getList(Integer curPage, Integer pageSize);

    /**
     * 根据id查询角色
     * @param id
     * @return
     */
    public SysRole getById(Long id);

    /**
     * 根据角色名查询角色
     * @param name
     * @return
     */
    public Map<String,Object> getByName(String name,Integer curPage, Integer pageSize);

    /**
     * 添加角色
     * @param sysRole
     * @return
     */
    public Serializable addRole(SysRole sysRole);

    /**
     * 删除角色
     * @param id
     */
    public void deleteRole(Long id);

    /**
     * 修改角色
     * @param sysRole
     */
    public void updateRole(SysRole sysRole);

    /**
     * 查询所有角色用于用户分配角色
     * @return
     */
    public List<SysRole> roleList();

}
