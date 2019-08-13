package com.lesson.dispatch.controller;

import com.lesson.dispatch.entity.AccWorkorder;
import com.lesson.dispatch.entity.BasAssociatemember;
import com.lesson.dispatch.service.BasAssociatememberService;
import com.lesson.dispatch.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("associa")
public class BasAssociatememberController {

    @Autowired
    private BasAssociatememberService basAssociatememberService;

    @PostMapping("basAssociatememberList")
    public ResponseResult basAssociatememberList() {
        List<BasAssociatemember> list = basAssociatememberService.basAssociatememberList();
        ResponseResult result = new ResponseResult();
        result.getData().put("list",list);
        return result;
    }

    /**
     * 转单给小件员，成功，下发短信
     * @param empno
     * @return
     */
    @PostMapping("transferSmallPart")
    public ResponseResult transferSmallPart(String empno){
        Map<String,Object> map = new HashMap<>();
        map.put("message",basAssociatememberService.transferSmallPart(empno));
        ResponseResult result = new ResponseResult();
        result.setMessage(map.get("message").toString());
        return result;
    }

    /**
     * 重发
     * @return
     */
    @PostMapping("retry")
    public ResponseResult retry( AccWorkorder accWorkorder){
        basAssociatememberService.retry(accWorkorder.getSmallmembernum());
        ResponseResult result = new ResponseResult();
        result.setMessage("重发成功");
        return  result;
    }

}
