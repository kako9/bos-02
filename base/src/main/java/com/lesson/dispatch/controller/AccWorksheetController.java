package com.lesson.dispatch.controller;

import com.lesson.dispatch.entity.AccWorksheet;
import com.lesson.dispatch.service.AccWorksheetService;
import com.lesson.dispatch.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("worksheet")
public class AccWorksheetController {

    @Autowired
    private AccWorksheetService accWorksheetService;

    /**
     * 查询所有工作单
     * @return
     */
    @PostMapping("accWorksheetList")
    public ResponseResult accWorksheetList(){
        List<AccWorksheet> list = accWorksheetService.accWorksheetList();
        ResponseResult result = new ResponseResult();
        result.getData().put("list",list);
        return  result;
    }
}
