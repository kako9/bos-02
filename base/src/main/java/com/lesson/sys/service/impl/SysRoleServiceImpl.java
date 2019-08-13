package com.lesson.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lesson.sys.entity.SysRole;
import com.lesson.sys.entity.SysRoleExample;
import com.lesson.sys.mapper.SysRoleMapper;
import com.lesson.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysRoleServiceImpl implements SysRoleService{

    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 查询所有角色
     * @return
     */
    @Override
    public Map<String,Object> getList(Integer curPage, Integer pageSize) {
        PageHelper pageHelper = new PageHelper();
        Page page = pageHelper.startPage(curPage,pageSize,true);
        List<SysRole> list = sysRoleMapper.selectByExample(null);
        Map<String,Object> map = new HashMap<>();
        map.put("page", page.getResult());
        map.put("total", page.getTotal());
        return map;
    }

    /**
     * 根据id查询角色
     * @param id
     * @return
     */
    @Override
    public SysRole getById(Long id) {
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(id);
        return sysRole;
    }

    /**
     * 根据角色名查询角色
     * @param name
     * @return
     */
    @Override
    public Map<String,Object> getByName(String name,Integer curPage, Integer pageSize) {
        PageHelper pageHelper = new PageHelper();
        Page page = pageHelper.startPage(curPage,pageSize,true);
        List<SysRole> list = sysRoleMapper.getByName("%"+name+"%");
        Map<String,Object> map = new HashMap<>();
        map.put("page", page.getResult());
        map.put("total", page.getTotal());
        return map;
    }

    /**
     * 添加角色
     * @param sysRole
     * @return
     */
    @Override
    public Serializable addRole(SysRole sysRole) {
       Integer id = sysRoleMapper.insert(sysRole);
       return id;
    }

    /**
     * 删除角色 软删除改变角色状态
     * @param id
     */
    @Override
    public void deleteRole(Long id) {
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(id);
        sysRole.setDelFlag(new Byte("-1"));
        sysRoleMapper.updateByPrimaryKeySelective(sysRole);
    }

    /**
     * 修改角色
     * @param sysRole
     */
    @Override
    public void updateRole(SysRole sysRole) {
        sysRoleMapper.updateByPrimaryKeySelective(sysRole);
    }

    /**
     * 查询所有角色，用户用户分配角色
     * @return
     */
    @Override
    public List<SysRole> roleList() {
        SysRoleExample example = new SysRoleExample();
        SysRoleExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(new Byte("0"));
        List<SysRole> list = sysRoleMapper.selectByExample(example);
        return list;
    }
}
