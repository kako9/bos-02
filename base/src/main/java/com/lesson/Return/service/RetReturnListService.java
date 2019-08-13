package com.lesson.Return.service;

import com.lesson.Return.entity.RetReturnList;
import java.util.Map;

public interface RetReturnListService {

    /**
     * 查询所有返货单
     * @return
     */
    public Map<String,Object> retReturnListList(Integer curPage, Integer pageSize);

    /**
     * 根据条件查询返货单
     * @return
     */
    public Map<String,Object> getRetReturnListListTerm(Integer curPage, Integer pageSize,RetReturnList retReturnList);

    /**
     * 删除返货单
     * @param id
     */
    public void retReturnListDelete(Integer id);

    /**
     * 添加返货单
     * @param retReturnList
     */
    public void addRetReturnList(RetReturnList retReturnList);

    /**
     * 修改返货单
     * @param retReturnList
     */
    public void updateRetReturnList(RetReturnList retReturnList);
}
