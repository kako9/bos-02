package com.lesson.sys.mapper;

import com.lesson.sys.entity.SysUser;
import com.lesson.sys.entity.SysUserExample;
import java.util.List;

import com.lesson.sys.entity.UserAndRoles;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {

    /**
     * 查询用户对应的角色id
     */
    public List<UserAndRoles> getUserRoleId(Long userId);

    /**
     * 根据用户名查询角色和觉角色对应的权限
     * @param name
     * @return
     */
    public List<SysUser> findUserByNameAndRoleAndMenu(String name);

    /**
     * 根据用户名查询对应角色
     * @param username
     * @return
     */
    public List<String> findUserRoles(String username);

    /**
     * 根据名字模糊查询
     * @param username
     * @return
     */
    public List<SysUser> getByName(String username);

    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}