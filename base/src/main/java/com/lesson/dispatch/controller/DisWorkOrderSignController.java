package com.lesson.dispatch.controller;

import com.lesson.dispatch.entity.AccWorksheet;
import com.lesson.dispatch.entity.DisWorkordersign;
import com.lesson.dispatch.service.AccWorksheetService;
import com.lesson.dispatch.service.DisWorkOrderSignService;
import com.lesson.dispatch.util.ResponseResult;
import com.lesson.sys.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("workOrderSign")
public class DisWorkOrderSignController {

    @Autowired
    private DisWorkOrderSignService disWorkOrderSignService;

    @Autowired
    private AccWorksheetService accWorksheetService;

    /**
     * 查询所有签收工作单
     * @param curPage
     * @param pageSize
     * @return
     */
    @PostMapping("disWorkOrderSignList")
    public ResponseResult disWorkOrderSignList(Integer curPage, Integer pageSize){
        Map<String,Object> map = disWorkOrderSignService.disWorkordersignList(curPage,pageSize);
        ResponseResult result = new ResponseResult();
        result.getData().put("list",map.get("page"));
        result.getData().put("total",map.get("total"));
        return result;
    }

    /**
     * 根据条件查询签收工作单
     * @return
     */
    @PostMapping("conditionDisWorkordersignList")
    public ResponseResult conditionDisWorkordersignList(Integer curPage, Integer pageSize,String workorderid,String worksheetno){
        DisWorkordersign disWorkordersign = new DisWorkordersign();
        disWorkordersign.setWorkorderid("%"+workorderid+"%");
        disWorkordersign.setWorksheetno("%"+worksheetno+"%");
        Map<String,Object> map = disWorkOrderSignService.conditionDisWorkordersignList(curPage,pageSize,disWorkordersign);
        ResponseResult result = new ResponseResult();
        result.getData().put("list",map.get("page"));
        result.getData().put("total",map.get("total"));
        return result;
    }

    /**
     * 添加签收工作单
     * @param disWorkordersign
     * @return
     */
    @PostMapping("addDisWorkOrderSign")
    public ResponseResult addDisWorkOrderSign(DisWorkordersign disWorkordersign){
        AccWorksheet accWorksheet = accWorksheetService.getById(Integer.valueOf(disWorkordersign.getWorkorderid()));
        disWorkordersign.setWorksheetno(accWorksheet.getWorksheetno());

        DateFormat df = new SimpleDateFormat("HHmmss");
        Calendar calendar = Calendar.getInstance();
        String dateName = df.format(calendar.getTime());
        disWorkordersign.setSignunit(Integer.valueOf((dateName)));
        String dateName2 = df.format(calendar.getTime());
        disWorkordersign.setInputpersoncode(Integer.valueOf((dateName2)));
        disWorkordersign.setSigntime(new Date());

        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        SysUser sysUser = (SysUser) session.getAttribute("USER_SESSION");

        disWorkordersign.setInputpersonid(sysUser.getId().intValue());
        disWorkordersign.setInputid(sysUser.getDeptId().intValue());
        disWorkordersign.setInputtime(new Date());
        disWorkOrderSignService.addDisWorkordersign(disWorkordersign);
        ResponseResult result = new ResponseResult();
        result.setMessage("添加成功");
        return result;
    }

    /**
     * 修改签收工作单
     * @param disWorkordersign
     * @return
     */
    @PostMapping("updateDisWorkOrderSign")
    public ResponseResult updateDisWorkOrderSign( DisWorkordersign disWorkordersign){
        disWorkOrderSignService.updateDisWorkordersign(disWorkordersign);
        ResponseResult result = new ResponseResult();
        result.setMessage("修改成功");
        return result;
    }

    /**
     * 取消签收申请确认-申请
     * @param disWorkordersign
     * @return
     */
    @PostMapping("applyfor")
    public ResponseResult applyfor( DisWorkordersign disWorkordersign){
        DateFormat df = new SimpleDateFormat("HHmmss");
        Calendar calendar = Calendar.getInstance();
        String dateName = df.format(calendar.getTime());
        disWorkordersign.setRequestcode("SQD"+dateName);
        disWorkordersign.setRequeststate(3);
        disWorkOrderSignService.updateDisWorkordersign(disWorkordersign);
        ResponseResult result = new ResponseResult();
        result.setMessage("申请成功");
        return result;
    }

    /**
     * 取消签收申请确认-确认
     * @param disWorkordersign
     * @return
     */
    @PostMapping("notarize")
    public ResponseResult notarize( DisWorkordersign disWorkordersign){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        SysUser sysUser = (SysUser) session.getAttribute("USER_SESSION");
        disWorkordersign.setRequeststate(1);
        disWorkordersign.setConfirmor(sysUser.getUsername());
        disWorkOrderSignService.updateDisWorkordersign(disWorkordersign);
        ResponseResult result = new ResponseResult();
        result.setMessage("确认成功");
        return result;
    }

    /**
     * 取消签收申请确认-作废
     * @param disWorkordersign
     * @return
     */
    @PostMapping("cancellation")
    public ResponseResult cancellation( DisWorkordersign disWorkordersign){
        disWorkordersign.setRequeststate(2);
        disWorkOrderSignService.updateDisWorkordersign(disWorkordersign);
        ResponseResult result = new ResponseResult();
        result.setMessage("作废成功");
        return result;
    }


}
