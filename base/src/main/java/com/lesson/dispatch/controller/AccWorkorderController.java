package com.lesson.dispatch.controller;

import com.lesson.dispatch.entity.AccWorkorder;
import com.lesson.dispatch.service.AccWorkorderService;
import com.lesson.dispatch.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@RequestMapping("workorder")
public class AccWorkorderController {

    @Autowired
    private AccWorkorderService accWorkorderService;

    private Lock lock = new ReentrantLock();

    @PostMapping("singlePinAndAdd")
    public ResponseResult singlePinAndAdd( AccWorkorder accWorkorder){
        AccWorkorder workorder = new AccWorkorder();
        workorder.setBusinessnoticeno(accWorkorder.getBusinessnoticeno());
        workorder.setJobno(accWorkorder.getJobno());
        workorder.setJobtype(1);
        workorder.setPickupstatus(1);
        lock.lock();
        try {
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            Calendar calendar = Calendar.getInstance();
            String dateName = df.format(calendar.getTime());
            Long shortmessageint = Long.valueOf(dateName+accWorkorder.getId());
            workorder.setShortmessageint(shortmessageint);
        } catch (Exception e) {
            System.out.println("线程发生了异常释放锁");
        }finally {
            System.out.println("线程执行完毕释放锁");
            lock.unlock(); //释放锁
        }
        workorder.setWorkgenerationtime(accWorkorder.getWorkgenerationtime());
        workorder.setAftersinglenum(accWorkorder.getAftersinglenum());
        workorder.setSmallmembernum(accWorkorder.getSmallmembernum());
        workorder.setPickupunit(accWorkorder.getPickupunit());
        workorder.setPickuptime(accWorkorder.getPickuptime());
        workorder.setSortingcode(accWorkorder.getSortingcode());
        accWorkorderService.deleteAccWorkorder(accWorkorder.getId());
        accWorkorderService.addAccWorkorder(workorder);
        ResponseResult result = new ResponseResult();
        result.setMessage("操作成功");
        return result;
    }

    /**
     * 销单，
     * * @param accBusinessadmissibility
     * @return
     */
    @PostMapping("singlePin")
    public ResponseResult singlePin( AccWorkorder accWorkorder){
        accWorkorderService.updateAccWorkorder(accWorkorder);
        ResponseResult result = new ResponseResult();
        result.setMessage("销单成功");
        return result;
    }

    /**
     * 退回给上一次
     * * @param accBusinessadmissibility
     * @return
     */
    @PostMapping("sendBack")
    public ResponseResult sendBack( AccWorkorder accWorkorder){
        accWorkorderService.sendBack(accWorkorder);
        ResponseResult result = new ResponseResult();
        result.setMessage("退回成功");
        return result;
    }

    /**
     * 分配
     * @param accWorkorder
     * @param deptId
     * @return
     */
    @PostMapping("allocation")
    public ResponseResult allocation( AccWorkorder accWorkorder,Integer deptId){
        accWorkorder.setPickupunit(deptId);
        accWorkorderService.allocation(accWorkorder);
        ResponseResult result = new ResponseResult();
        result.setMessage("分配成功");
        return result;
    }

}
