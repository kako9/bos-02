package com.lesson.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lesson.sys.entity.SysUser;
import com.lesson.sys.entity.SysUserExample;
import com.lesson.sys.entity.UserAndRoles;
import com.lesson.sys.mapper.SysUserMapper;
import com.lesson.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     *查询对应用户所有的角色id
     * @param userId
     * @return
     */
    @Override
    public List<Long> getUserRoleId(Long userId) {
        List<Long> listR = new ArrayList<>();
        List<UserAndRoles> list = sysUserMapper.getUserRoleId(userId);
        for (UserAndRoles userAndRoles:list){
            listR.add(userAndRoles.getRoleId());
        }
        return listR;
    }

    /**
     * 根据用户名查询角色和觉角色对应的权限
     * @param name
     * @return
     */
    @Override
    public SysUser findUserByNameAndRoleAndMenu(String name) {
        List<SysUser> list = sysUserMapper.findUserByNameAndRoleAndMenu(name);
        if(list!=null && list.size()==1){
            return list.get(0);
        }
        return null;

    }

    /**
     * 用户登录
     * @param sysUser
     * @return
     */
    @Override
    public SysUser login(SysUser sysUser) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(sysUser.getUsername());
        criteria.andPasswordEqualTo(sysUser.getPassword());
        criteria.andStatusEqualTo(new Byte("1"));
        criteria.andDelFlagEqualTo(new Byte("0"));
        List<SysUser> list =  sysUserMapper.selectByExample(example);
        if(list!=null && list.size()==1){
            return list.get(0);
        }
        return  null;

    }

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    @Override
    public SysUser findUserByUserName(String username) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<SysUser> list =  sysUserMapper.selectByExample(example);
        if(list!=null && list.size()==1){
            return list.get(0);
        }
        return null;
    }

    /**
     * 根据用户名查询角色
     * @param username
     * @return
     */
    @Override
    public List<String> findUserRoles(String username) {
        List<String> roles = sysUserMapper.findUserRoles(username);
        return roles;
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public Map<String,Object> userList(Integer curPage, Integer pageSize) {
        PageHelper pageHelper = new PageHelper();
        Page page = pageHelper.startPage(curPage,pageSize,true);
        List<SysUser> list =sysUserMapper.selectByExample(null);
        Map<String,Object> map = new HashMap<>();
        map.put("page", page.getResult());
        map.put("total", page.getTotal());
        return map;
    }

    /**
     * 根据id删除,软删除只改变是否删除列
     * @param id
     */
    @Override
    public void deleteUser(Integer id) {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(new Long(id));
        sysUser.setDelFlag(new Byte("-1"));
        sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public SysUser getById(Integer id) {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(new Long(id));
        return sysUser;
    }

    /**
     * 修改用户信息
     * @param sysUser
     */
    @Override
    public void updateUser(SysUser sysUser) {
        sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    /**
     * 添加用户
     * @param sysUser
     * @return
     */
    @Override
    public Serializable addUser(SysUser sysUser) {
        Integer id = sysUserMapper.insert(sysUser);
        return id;
    }

    /**
     * 根据名字模糊查询
     * @param byName
     * @return
     */
    @Override
    public Map<String,Object> getByName(Integer curPage, Integer pageSize,String byName) {
        PageHelper pageHelper = new PageHelper();
        Page page = pageHelper.startPage(curPage,pageSize,true);
        List<SysUser> list =  sysUserMapper.getByName("%"+byName+"%");
        Map<String,Object> map = new HashMap<>();
        map.put("page", page.getResult());
        map.put("total", page.getTotal());
        return map;
    }
}
