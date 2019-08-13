package com.lesson.sys.controller;

import com.lesson.sys.entity.CommonEntity;
import com.lesson.sys.entity.SysMenu;
import com.lesson.sys.service.SysMenuService;
import com.lesson.sys.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 查询所有菜单
     * @return
     */
    @PostMapping("menuList")
    public ResponseResult menuList(){
        List<CommonEntity> list = sysMenuService.menuList();
        ResponseResult result = new ResponseResult();
        result.getData().put("list",list);
        return result;
    }

    /**
     * 添加菜单
     * @param sysMenu
     * @return
     */
    @PostMapping("addMenu")
    public ResponseResult addMenu( SysMenu sysMenu){
        sysMenu.setDelFlag(new Byte("0"));
        sysMenuService.addMenu(sysMenu);
        ResponseResult result = new ResponseResult();
        result.getData().put("message","添加成功");
        return result;
    }

    /**
     * 删除菜单
     * @param id
     * @return
     */
    @PostMapping("deleteMenu")
    public ResponseResult deleteMenu(Long id){
        sysMenuService.deleteMenu(id);
        ResponseResult result = new ResponseResult();
        result.getData().put("message","删除成功");
        return result;
    }

    /**
     * 修改菜单
     * @param sysMenu
     * @return
     */
    @PostMapping("updateMenu")
    public ResponseResult updateMenu( SysMenu sysMenu){
        sysMenuService.updateMenu(sysMenu);
        ResponseResult result = new ResponseResult();
        result.getData().put("message","修改成功");
        return result;
    }

}
