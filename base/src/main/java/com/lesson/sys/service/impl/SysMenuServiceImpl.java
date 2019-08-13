package com.lesson.sys.service.impl;

import com.lesson.sys.entity.CommonEntity;
import com.lesson.sys.entity.SysMenu;
import com.lesson.sys.mapper.SysMenuMapper;
import com.lesson.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * 查询所有菜单
     * @return
     */
    @Override
    public List<CommonEntity> menuList() {
        List<CommonEntity> items = new ArrayList<>();
        for (SysMenu menu:sysMenuMapper.selectByExample(null)){
            CommonEntity common = new CommonEntity();
            if(menu.getParentId().longValue()==0){
                common.setId(menu.getId());
                common.setUrl(menu.getUrl());
                common.setDelFlag(menu.getDelFlag());
                common.setLabel(menu.getName());
                common.setChildren(getChildrenMenu(menu.getId(),sysMenuMapper.selectByExample(null)));
                items.add(common);
            }
        }
        return items;
    }

    @Override
    public List<CommonEntity> getChildrenMenu(Long parentId,List<SysMenu> list) {
        List<CommonEntity> items = new ArrayList<>();
        for (SysMenu menu:list){
            CommonEntity common = new CommonEntity();
            if(menu.getParentId().longValue()==0){
                continue;
            }
            if(menu.getParentId().longValue()==parentId){
                common.setId(menu.getId());
                common.setUrl(menu.getUrl());
                common.setDelFlag(menu.getDelFlag());
                common.setLabel(menu.getName());
                common.setChildren(getChildrenMenu(menu.getId(),list));
                items.add(common);
            }
        }
        return items;
    }


    /**
     * 添加菜单
     * @param sysMenu
     * @return
     */
    @Override
    public Serializable addMenu(SysMenu sysMenu) {
        return sysMenuMapper.insert(sysMenu);
    }

    /**
     * 删除菜单
     * @param id
     */
    @Override
    public void deleteMenu(Long id) {
        SysMenu sysMenu = sysMenuMapper.selectByPrimaryKey(id);
        sysMenu.setDelFlag(new Byte("-1"));
        sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
    }

    /**
     * 修改菜单信息
     * @param sysMenu
     */
    @Override
    public void updateMenu(SysMenu sysMenu) {
        sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
    }

    /**
     * 根据id查询菜单
     * @param id
     * @return
     */
    @Override
    public SysMenu getById(Long id) {
        return sysMenuMapper.selectByPrimaryKey(id);
    }
}
