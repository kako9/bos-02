package com.lesson.dispatch.service;

import com.lesson.dispatch.entity.BasAssociatemember;

import java.util.List;
import java.util.Map;

public interface BasAssociatememberService {

    /**
     * 查询所有小件员
     * @return
     */
    public List<BasAssociatemember> basAssociatememberList();

    /**
     * 抓单给小件员成功，下发短信
     * @param empno
     * @return
     */
    public Map<String,Object>  transferSmallPart(String empno);

    /**
     * 重发
     * @param id
     * @return
     */
    public Map<String,Object> retry(Integer id);
}
