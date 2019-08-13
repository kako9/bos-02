package com.lesson.sys.controller;

import com.lesson.sys.entity.SysRole;
import com.lesson.sys.entity.SysUser;
import com.lesson.sys.service.SysRoleService;
import com.lesson.sys.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 查询所有角色
     * @return
     */
    @PostMapping("roleList")
    public ResponseResult roleList(Integer curPage,Integer pageSize){
        Map<String,Object> map = sysRoleService.getList(curPage,pageSize);
        ResponseResult result = new ResponseResult();
        result.getData().put("list",map.get("page"));
        result.getData().put("total",map.get("total"));
        return result;
    }

    /**
     * 删除角色
     * @return
     */
    @PostMapping("deleteRole")
    public ResponseResult deleteRole(Long id){
        sysRoleService.deleteRole(id);
        ResponseResult result = new ResponseResult();
        result.getData().put("message","删除成功");
        return result;
    }

    /**
     * 添加角色
     * @return
     */
    @PostMapping("addRole")
    public ResponseResult addRole( SysRole sysRole, HttpSession session){
        SysUser user = (SysUser) session.getAttribute("loginUser");
        sysRole.setCreateBy(user.getUsername());
        sysRole.setCreateTime(new Date());
        sysRole.setLastUpdateBy(user.getUsername());
        sysRole.setLastUpdateTime(new Date());
        sysRole.setDelFlag(new Byte("0"));
        sysRoleService.addRole(sysRole);
        ResponseResult result = new ResponseResult();
        result.getData().put("message","添加成功");
        return result;
    }

    /**
     * 修改角色
     * @return
     */
    @PostMapping("updateRole")
    public ResponseResult updateRole( SysRole sysRole,HttpSession session){
        SysUser user = (SysUser) session.getAttribute("loginUser");
        sysRole.setLastUpdateBy(user.getUsername());
        sysRole.setLastUpdateTime(new Date());
        sysRoleService.updateRole(sysRole);
        ResponseResult result = new ResponseResult();
        result.getData().put("message","修改成功");
        return result;
    }

    /**
     * 根据名字模糊查询
     * @param name
     * @return
     */
    @PostMapping("getByName")
    public ResponseResult getByName(String name,Integer curPage, Integer pageSize) {
        Map<String,Object> map = sysRoleService.getByName(name,curPage,pageSize);
        ResponseResult result = new ResponseResult();
        result.getData().put("list",map.get("page"));
        result.getData().put("total",map.get("total"));
        return result;
    }

    /**
     * 查询所有角色，用户用户的角色分配
     * @return
     */
    @PostMapping("getRoleList")
    public ResponseResult getRoleList(){
        ResponseResult result = new ResponseResult();
        result.getData().put("roles",sysRoleService.roleList());
        return result;
    }

}
