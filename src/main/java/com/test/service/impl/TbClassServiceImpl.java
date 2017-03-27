package com.test.service.impl;

import com.test.dao.TbClassMapper;
import com.test.model.TbClass;
import com.test.service.TbClassService;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by 张宏浩 on 2017/3/1.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbClassServiceImpl implements TbClassService {
    @Resource
    private TbClassMapper classMapper;

    public int judgeClass(int gradeId , String name){
        TbClass tbClass  =classMapper.selectByIdAndName(name,gradeId);
        return tbClass.getId();
    }
    public TbClass getById(int id) {
        return classMapper.selectByPrimaryKey(id);
    }
    public int  insertClass(TbClass tbClass){
        return classMapper.insert(tbClass);
    }

    public List<TbClass> listByGraId(int graId) {
        List<TbClass> list = classMapper.listByGraId(graId);
        if(list ==null) {
            return null;
        }else {
            return list;
        }
    }

    //根据关键字查找班级
    public List<TbClass> listByKeyword(String keyword) {
        return classMapper.listByKeyword(keyword);
    }

    public List<TbClass> selectByPage(int gradeId, int startPos, int pageSize) {
        return classMapper.selectByPage(gradeId,startPos,pageSize);
    }

    public int getCount(int gradeId) {
        return classMapper.getCount(gradeId);
    }

    public int getClassCount(int gradeId, String keyword) {
        return classMapper.getClassCount(gradeId,keyword);
    }

    public List<TbClass> selectClass(int gradeId, String keyword, int startPos, int pageSize) {
        return classMapper.selectClass(gradeId,keyword,startPos,pageSize);
    }
}
