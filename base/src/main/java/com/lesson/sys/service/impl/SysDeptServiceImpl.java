package com.lesson.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lesson.sys.entity.SysDept;
import com.lesson.sys.entity.SysDeptExample;
import com.lesson.sys.mapper.SysDeptMapper;
import com.lesson.sys.service.SysDeptService;
import com.lesson.sys.util.SysDeptGroupUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    private SysDeptMapper sysDeptMapper;


    /**
     * 查询所有部门，
     * @return
     */
    @Override
    public List<SysDept> dpetList() {
        SysDeptExample sysDeptExample = new SysDeptExample();
        SysDeptExample.Criteria criteria = sysDeptExample.createCriteria();
        criteria.andDelFlagEqualTo(new Byte("0"));
        List<SysDept> list = sysDeptMapper.selectByExample(sysDeptExample);
        SysDeptGroupUtil util = new SysDeptGroupUtil();
        list = util.getFirstDept(list);
        return list;
    }

    /**
     * 修改部门
     * @param sysDept
     */
    @Override
    public void updateDept(SysDept sysDept) {
        sysDeptMapper.updateByPrimaryKeySelective(sysDept);
    }

    /**
     * 删除部门，软删除，修改状态
     * @param id
     */
    @Override
    public void deleteDept(Long id) {
        SysDept sysDept = sysDeptMapper.selectByPrimaryKey(id);
        sysDept.setDelFlag(new Byte("-1"));
        sysDeptMapper.updateByPrimaryKeySelective(sysDept);
    }

    /**
     * 添加部门
     * @param sysDept
     * @return
     */
    @Override
    public Serializable addDept(SysDept sysDept) {
        return sysDeptMapper.insert(sysDept);
    }

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    @Override
    public SysDept getById(Long id) {
        return sysDeptMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有部门
     * @param curPage
     * @param pageSize
     * @return
     */
    @Override
    public Map<String, Object> getList(Integer curPage, Integer pageSize) {
        PageHelper pageHelper = new PageHelper();
        Page page = pageHelper.startPage(curPage,pageSize,true);
        List<SysDept> list = sysDeptMapper.selectByExample(null);
        Map<String,Object> map = new HashMap<>();
        map.put("page", page.getResult());
        map.put("total", page.getTotal());
        return map;
    }

    /**
     * 根据部门名称模糊查询
     * @param name
     * @param curPage
     * @param pageSize
     * @return
     */
    @Override
    public Map<String, Object> getByName(String name, Integer curPage, Integer pageSize) {
        PageHelper pageHelper = new PageHelper();
        Page page = pageHelper.startPage(curPage,pageSize,true);
        List<SysDept> list = sysDeptMapper.getByName("%"+name+"%");
       /* SysDeptGroupUtil util = new SysDeptGroupUtil();
        list = util.getFirstDept(list);*/
        Map<String,Object> map = new HashMap<>();
        map.put("page", page.getResult());
        map.put("total", page.getTotal());
        return map;
    }

    /**
     * 根据上级id查询部门
     * @param parentId
     * @return
     */
    @Override
    public List<SysDept> getParentId(Integer parentId){
        SysDeptExample example = new SysDeptExample();
        SysDeptExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(new Long(parentId));
        List<SysDept> list = sysDeptMapper.selectByExample(example);
        return list;
    }

    /**
     * 根据登录的用户的部门查询下级部门
     * @param parentId
     * @return
     */
    @Override
    public List<SysDept> getByParentID(Long parentId) {
        SysDeptExample example = new SysDeptExample();
        SysDeptExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(new Long(parentId));
        List<SysDept> list = sysDeptMapper.selectByExample(example);
        return list;
    }

    ;
}
