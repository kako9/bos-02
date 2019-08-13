package com.lesson.sys.controller;

import com.lesson.sys.entity.SysDept;
import com.lesson.sys.entity.SysUser;
import com.lesson.sys.service.SysDeptService;
import com.lesson.sys.service.SysUserService;
import com.lesson.sys.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("dept")
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 查询所有部门
     * @return
     */
    @PostMapping("deptList")
    public ResponseResult depeList(){
        ResponseResult result = new ResponseResult();
        result.getData().put("deptList",sysDeptService.dpetList());
        return result;
    }

    /**
     * 修改部门信息
     * @param sysDept
     * @param session
     * @return
     */
    @PostMapping("updateDept")
    public ResponseResult updateDept( SysDept sysDept, HttpSession session){
        SysUser user = (SysUser) session.getAttribute("loginUser");
        sysDept.setLastUpdateBy(user.getUsername());
        sysDept.setLastUpdateTime(new Date());
        sysDeptService.updateDept(sysDept);
        ResponseResult result = new ResponseResult();
        result.getData().put("message","修改成功");
        return result;
    }

    /**
     * 删除部门
     * @param id
     * @return
     */
    @PostMapping("deleteDept")
    public ResponseResult deleteDept(Long id){
        sysDeptService.deleteDept(id);
        ResponseResult result = new ResponseResult();
        result.getData().put("message","删除成功");
        return result;
    }

    /**
     * 添加部门
     * @return
     */
    @PostMapping("addDept")
    public ResponseResult addDept( SysDept sysDept, HttpSession session){
        sysDept.setDelFlag(new Byte("0"));
        SysUser user = (SysUser) session.getAttribute("loginUser");
        sysDept.setCreateBy(user.getUsername());
        sysDept.setCreateTime(new Date());
        sysDept.setLastUpdateBy(user.getUsername());
        sysDept.setLastUpdateTime(new Date());
        sysDeptService.addDept(sysDept);
        ResponseResult result = new ResponseResult();
        result.getData().put("message","添加成功");
        return result;
    }

    /**
     * 根据id查询
     * @return
     */
    @PostMapping("getById")
    public ResponseResult getById(Long  id){
        SysDept sysDept = sysDeptService.getById(id);
        ResponseResult result = new ResponseResult();
        result.getData().put("sysDept",sysDept);
        return result;
    }

    /**
     * 查询所有部门
     * @param curPage
     * @param pageSize
     * @return
     */
    @PostMapping("getList")
    public ResponseResult getList(Integer curPage,Integer pageSize){
        Map<String,Object> map = sysDeptService.getList(curPage,pageSize);
        ResponseResult result = new ResponseResult();
        result.getData().put("list",map.get("page"));
        result.getData().put("total",map.get("total"));
        return result;
    }

    /**
     * 根据部门名称模糊查询
     * @return
     */
    @PostMapping("getByName")
    public ResponseResult getByName(String name,Integer curPage,Integer pageSize){
        Map<String,Object> map = sysDeptService.getByName(name,curPage,pageSize);
        ResponseResult result = new ResponseResult();
        result.getData().put("list",map.get("page"));
        result.getData().put("total",map.get("total"));
        return result;
    }

    /**
     * 根据上级id查询部门
     * @param parentId
     * @return
     */
    @PostMapping("getByParentId")
    public ResponseResult getByParentId(Integer parentId){
        List<SysDept> list = sysDeptService.getParentId(parentId);
        ResponseResult result = new ResponseResult();
        result.getData().put("children",list);
        return result;
    }

    /**
     * 根据登录的用户的部门查询下级部门
     */
    @PostMapping("getByParentIdSysDept")
    public ResponseResult getByParentIdSysDept(HttpSession session){
        SysUser sysUser = (SysUser) session.getAttribute("loginUser");
        SysUser user = sysUserService.findUserByUserName(sysUser.getUsername());
        List<SysDept> deptList = sysDeptService.getByParentID(user.getDeptId());
        ResponseResult result = new ResponseResult();
        result.getData().put("deptList",deptList);
        return result;
    }

}
