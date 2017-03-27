package com.test.service.impl;

import com.test.dao.GradeMapper;
import com.test.model.Grade;
import com.test.service.GradeService;
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
public class GradeServiceImpl implements GradeService{
    @Resource
    private GradeMapper gradeMapper;

    private Grade grade;

    public int judgeGrade(int academyId ,String name){
        grade = gradeMapper.selectByIdAndName(name,academyId);
        return grade.getId();
    }

    public Grade getById(int id){
        grade =gradeMapper.selectByPrimaryKey(id);
        return grade;
    }

    public List<Grade> listByAcaId(int acaId){
        List<Grade> list = gradeMapper.listByAcaId(acaId);
        if(list ==null) {
            return null;
        }else {
            return list;
        }
    }
}
