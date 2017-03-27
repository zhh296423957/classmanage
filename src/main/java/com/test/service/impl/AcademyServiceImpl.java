package com.test.service.impl;

import com.test.dao.AcademyMapper;
import com.test.model.Academy;
import com.test.service.AcademyService;
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
public class AcademyServiceImpl implements AcademyService{

    @Resource
    private AcademyMapper academyMapper;

    private Academy academy;

    public int judgeAcademy(int id ,String name){
        academy = academyMapper.selectByIdAndName(name,id);
        return academy.getId();
    }

    //根据id查找学院
    public Academy getById(int id){
        academy = academyMapper.selectByPrimaryKey(id);
        return academy;
    }



    //根据学校id查找所有的学院
    public List<Academy> lists(int schoolId) {
        List<Academy> lists = academyMapper.listBySchoolId(schoolId);
        if(lists == null ){
            return null;
        }else {
            return lists;
        }
    }
}
