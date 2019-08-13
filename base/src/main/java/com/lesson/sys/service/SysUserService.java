package com.lesson.sys.service;

import com.lesson.sys.entity.SysUser;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface SysUserService {

    /**
     * 查询用户对应的角色id
     */
    public List<Long> getUserRoleId(Long userId);

    /**
     * 根据用户名查询角色和觉角色对应的权限
     * @param name
     * @return
     */
    public SysUser findUserByNameAndRoleAndMenu(String name);


    /**
     * 用户登录
     * @param sysUser
     * @return
     */
    public SysUser login(SysUser sysUser);

    /**
     * 根据用户名查询用户信息
     * @return
     */
    public SysUser findUserByUserName(String username);

    /**
     * 根据用户名获得角色的集合
     * @param username
     * @return
     */
    public List<String> findUserRoles(String username);

    /**
     * 如果user为空查询所有用户
     * @return
     */
    public Map<String,Object> userList(Integer curPage, Integer pageSize);

    /**
     * 根据id查询
     * @param id
     */
    public void deleteUser(Integer id);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public SysUser getById(Integer id);

    /**
     * 修改用户信息
     * @param sysUser
     */
    public void updateUser(SysUser sysUser);

    /**
     * 添加用户
     * @param sysUser
     * @return
     */
    public Serializable addUser(SysUser sysUser);

    /**
     * 根据名字模糊查询
     * @param byName
     * @return
     */
    public Map<String,Object> getByName(Integer curPage, Integer pageSize,String byName);
}
