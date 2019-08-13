package com.lesson.dispatch.controller;

import com.lesson.dispatch.entity.AccBusinessadmissibility;
import com.lesson.dispatch.service.AccBusinessAdmissibilityService;
import com.lesson.sys.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("check")
public class AccBusinessadmissibilityController {

    @Autowired
    private AccBusinessAdmissibilityService accBusinessAdmissibilityService;
    /**
     * 查询所有业务受理
     * @param curPage
     * @param pageSize
     * @return
     */
    @PostMapping("list")
    public ResponseResult queryAccBusinessadmissibilityAndAccWorkorderList(Integer curPage,Integer pageSize){
        Map<String,Object> map = accBusinessAdmissibilityService.queryAccBusinessadmissibilityAndAccWorkorder(curPage,pageSize);
        ResponseResult result = new ResponseResult();
        result.getData().put("list",map.get("page"));
        result.getData().put("total",map.get("total"));
        return result;
    }

    /**
     * 根据条件查询所有业务受理
     * @param curPage
     * @param pageSize
     * @return
     */
    @PostMapping("listCondition")
    public ResponseResult queryAccBusinessadmissibilityAndAccWorkorderCondition(Integer curPage,Integer pageSize,String telphone,String businessnoticeno){
        AccBusinessadmissibility accBusinessadmissibility = new AccBusinessadmissibility();
        accBusinessadmissibility.setTelphone("%"+telphone+"%");
        accBusinessadmissibility.setBusinessnoticeno("%"+businessnoticeno+"%");
        Map<String,Object> map = accBusinessAdmissibilityService.queryAccBusinessadmissibilityAndAccWorkorderCondition(curPage,pageSize,accBusinessadmissibility);
        ResponseResult result = new ResponseResult();
        result.getData().put("list",map.get("page"));
        result.getData().put("total",map.get("total"));
        return result;
    }

    /**
     * 修改业务受理
     * @param accBusinessadmissibility
     * @return
     */
    @PostMapping("update")
    public ResponseResult updateAccBusinessadmissibilityAndAccWorkorder( AccBusinessadmissibility accBusinessadmissibility){
        accBusinessAdmissibilityService.updateAccBusinessadmissibility(accBusinessadmissibility);
        ResponseResult result = new ResponseResult();
        result.setMessage("修改成功");
        return result;
    }

}
