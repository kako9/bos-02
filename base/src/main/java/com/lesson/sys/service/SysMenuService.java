package com.lesson.sys.service;

import com.lesson.sys.entity.CommonEntity;
import com.lesson.sys.entity.SysMenu;

import java.io.Serializable;
import java.util.List;

public interface SysMenuService {

    public List<CommonEntity> menuList();

    public List<CommonEntity> getChildrenMenu(Long parentId,List<SysMenu> list);

    /**
     * 添加菜单
     * @param sysMenu
     * @return
     */
    public Serializable addMenu(SysMenu sysMenu);

    /**
     * 删除菜单
     * @param id
     */
    public void deleteMenu(Long id);

    /**
     * 修改菜单信息
     * @param sysMenu
     */
    public void updateMenu(SysMenu sysMenu);

    /**
     * 根据id查询菜单
     * @param id
     * @return
     */
    public SysMenu getById(Long id);
}
