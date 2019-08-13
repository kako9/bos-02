package com.lesson.Return.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lesson.Return.entity.IaeArrival;
import com.lesson.Return.entity.RetReturnList;
import com.lesson.Return.entity.RetReturnListExample;
import com.lesson.Return.mapper.RetReturnListMapper;
import com.lesson.Return.service.IaeArrivalService;
import com.lesson.Return.service.RetReturnListService;
import com.lesson.Return.util.ResponseResult;
import com.lesson.sys.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("returnList")
public class RetReturnListController{

    @Autowired
    private RetReturnListService retReturnListService;

    @Autowired
    private IaeArrivalService iaeArrivalService;

    /**
     * 查询所有签收单
     * @param curPage
     * @param pageSize
     * @return
     */
    @PostMapping("returnListList")
    public ResponseResult RetReturnListList(Integer curPage, Integer pageSize){
        Map<String,Object> map = retReturnListService.retReturnListList(curPage,pageSize);
        ResponseResult result = new ResponseResult();
        result.getData().put("list",map.get("page"));
        result.getData().put("total",map.get("total"));
        return result;
    }

    /**
     * 根据条件查询签收单
     * @param curPage
     * @param pageSize
     * @param applicationno
     * @param worksheetno
     * @return
     */
    @PostMapping("getRetReturnListListTerm")
    public ResponseResult getRetReturnListListTerm(Integer curPage, Integer pageSize,String applicationno ,String worksheetno){
        RetReturnList retReturnList = new RetReturnList();
        retReturnList.setApplicationno("%"+applicationno+"%");
        retReturnList.setWorksheetno("%"+worksheetno+"%");
        Map<String,Object> map = retReturnListService.getRetReturnListListTerm(curPage,pageSize,retReturnList);
        ResponseResult result = new ResponseResult();
        result.getData().put("list",map.get("page"));
        result.getData().put("total",map.get("total"));
        return result;
    }

    /**
     * 作废
     * @param retReturnList
     * @return
     */
    @PostMapping("cancellation")
    public ResponseResult cancellation( RetReturnList retReturnList){
       retReturnList.setInvalidatesign(1);
       retReturnListService.updateRetReturnList(retReturnList);
       ResponseResult result = new ResponseResult();
       result.setMessage("作废成功");
       return result;
    }

    /**
     * 修改
     * @param retReturnList
     * @return
     */
    @PostMapping("updateRetReturnList")
    public ResponseResult updateRetReturnList( RetReturnList retReturnList){
        retReturnListService.updateRetReturnList(retReturnList);
        ResponseResult result = new ResponseResult();
        result.setMessage("修改成功");
        return result;
    }

    /**
     * 添加
     * @param retReturnList
     * @return
     */
    @PostMapping("addRetReturnList")
    public ResponseResult addRetReturnList(RetReturnList retReturnList){
        IaeArrival iaeArrival = iaeArrivalService.getById(retReturnList.getWorksheetno());
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        SysUser sysUser = (SysUser) session.getAttribute("USER_SESSION");

        DateFormat df = new SimpleDateFormat("dd HHmmss");
        Calendar calendar = Calendar.getInstance();
        String dateName = df.format(calendar.getTime());
        retReturnList.setApplicationno("SQD"+dateName.trim());
        retReturnList.setReturntype(1);
        retReturnList.setEntrytime(iaeArrival.getStoragedate());
        retReturnList.setReceivegunit(sysUser.getDeptId().intValue());
        retReturnList.setInvalidatesign(0);
        retReturnList.setReturnunit(sysUser.getDeptId().intValue());
        retReturnList.setRecordingtime(new Date());
        retReturnList.setEntryunit(sysUser.getDeptId().intValue());
        retReturnList.setPersonname(sysUser.getUsername());
        retReturnList.setTreatmentstate(1);
        retReturnList.setApreturnstatus(1);
        retReturnList.setIdentificationsign(0);

        retReturnListService.addRetReturnList(retReturnList);
        ResponseResult result = new ResponseResult();
        result.setMessage("添加成功");
        return result;
    }

    /**
     * 返货申请确认
     * @param retReturnList
     * @return
     */
    @PostMapping("confirmation")
    public ResponseResult confirmation( RetReturnList retReturnList) {
        retReturnList.setConfirmationtime(new Date());
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        SysUser sysUser = (SysUser) session.getAttribute("USER_SESSION");
        retReturnList.setConfirmationunit(sysUser.getDeptId().intValue());
        retReturnList.setConfirmationname(sysUser.getUsername());
        retReturnListService.updateRetReturnList(retReturnList);
        ResponseResult result = new ResponseResult();
        result.setMessage("返货申请确认成功");
        return result;
    }

    /**
     * 返货
     * @param retReturnList
     * @return
     */
    @PostMapping("returnTheGoods")
    public ResponseResult returnTheGoods( RetReturnList retReturnList) {
        retReturnList.setTreatmentstate(2);
        retReturnListService.updateRetReturnList(retReturnList);
        ResponseResult result = new ResponseResult();
        result.setMessage("返货成功");
        return result;
    }

    /**
     * 拒绝
     * @param retReturnList
     * @return
     */
    @PostMapping("refuse")
    public ResponseResult refuse( RetReturnList retReturnList) {
        retReturnList.setTreatmentstate(3);
        retReturnListService.updateRetReturnList(retReturnList);
        ResponseResult result = new ResponseResult();
        result.setMessage("拒绝成功");
        return result;
    }


}
