package com.lesson.Return.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lesson.Return.entity.RetReturnList;
import com.lesson.Return.entity.RetReturnListExample;
import com.lesson.Return.mapper.RetReturnListMapper;
import com.lesson.Return.service.RetReturnListService;
import com.lesson.sys.entity.SysDept;
import com.lesson.sys.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RetReturnListServiceImpl implements RetReturnListService {

    @Autowired
    private RetReturnListMapper retReturnListMapper;

    @Autowired
    private SysDeptMapper sysDeptMapper;


    /**
     * 查询所有返货单
     * @param curPage
     * @param pageSize
     * @return
     */
    @Override
    public Map<String, Object> retReturnListList(Integer curPage, Integer pageSize) {
        PageHelper pageHelper = new PageHelper();
        Page page = pageHelper.startPage(curPage,pageSize,true);
        List<RetReturnList> list = retReturnListMapper.retReturnListAndDeptList();
        for (RetReturnList retReturnList: list) {
            if (retReturnList.getConfirmationunit()!=null){
                SysDept sysDept = sysDeptMapper.selectByPrimaryKey(new Long(retReturnList.getConfirmationunit()));
                retReturnList.setConfirmationname(sysDept.getName());
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("page", page.getResult());
        map.put("total", page.getTotal());
        return map;
    }

    /**
     * 根据条件查询返货单
     * @param curPage
     * @param pageSize
     * @param retReturnList
     * @return
     */
    @Override
    public Map<String, Object> getRetReturnListListTerm(Integer curPage, Integer pageSize, RetReturnList retReturnList) {
        PageHelper pageHelper = new PageHelper();
        Page page = pageHelper.startPage(curPage,pageSize,true);
        List<RetReturnList> list = retReturnListMapper.getRetReturnListAndDeptListTerm(retReturnList);
        Map<String,Object> map = new HashMap<>();
        map.put("page", page.getResult());
        map.put("total", page.getTotal());
        return map;
    }

    /**
     * 删除返货单
     * @param id
     */
    @Override
    public void retReturnListDelete(Integer id) {
        retReturnListMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加返货单
     * @param retReturnList
     */
    @Override
    public void addRetReturnList(RetReturnList retReturnList) {
            retReturnListMapper.insert(retReturnList);
    }

    /**
     * 修改返货单
     * @param retReturnList
     */
    @Override
    public void updateRetReturnList(RetReturnList retReturnList) {
            retReturnListMapper.updateByPrimaryKeySelective(retReturnList);
    }
}
