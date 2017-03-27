package com.test.service.impl;

import com.test.dao.StudentMapper;
import com.test.model.Student;
import com.test.service.StudentService;
import com.test.utils.CreateMD5;
import com.test.utils.ReadExcel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by 张宏浩 on 2017/2/20.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class StudentServiceImpl implements StudentService {

    @Resource
    StudentMapper studentMapper;


    /**
     * 插入学生名单
     */
    public int insert(String path){
        int s = 0;
        ReadExcel readExcel = new ReadExcel();
        List<Student> list = new ArrayList<Student>();
        try {
            InputStream is = new FileInputStream(path);
            Map<String,List<Student>> map = readExcel.mapOfxlsx(is);
            System.out.println(map.get("Sheet1"));
            list = map.get("Sheet1");
            System.out.println(list);
            for(Student ls:list){
                ls.setPwd(CreateMD5.getMd5("123456"));
                s = studentMapper.insert(ls);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return s;
    }

    public List<Student> list(){
        List<Student> list = new ArrayList<Student>();
        list = studentMapper.list();
        return list;
    }

    //根据班级id查找所有的学生
    public List<Student> listForClassId(int classId){
        return studentMapper.listForClassId(classId);
    }

    /**
     * 根据学号查找学生信息
     */
    public Student getByNumber(String number){
        Student student =studentMapper.getByNumber(number);
        if(student == null) {
            return null;
        }else {
            return student;
        }
    }

    /**
     * 根据id查找学生
     */
    public Student getById(int id){
        Student student = studentMapper.selectByPrimaryKey(id);
        if(student ==null){
            return  null;
        }else {
            return student;
        }
    }

    /**
     * 修改学生密码
     */
    public int updatePwd(Student student){
        return studentMapper.updateByPrimaryKey(student);
    }

    //根据关键字查找学生
    public List<Student> listByKeyword(String keyword){
        return studentMapper.listByKeyword(keyword);
    }

    public List<Student> selectStudent(int classId, String keyword, int startPos, int pageSize) {
        return studentMapper.selectStudent(classId,keyword,startPos,pageSize);
    }

    public int getCount(int classId, String keyword) {
        return studentMapper.getCount(classId,keyword);
    }

    //根据id删除学生
    public int delete(int id){
        int flag;
        flag = studentMapper.deleteByPrimaryKey(id);
        return flag;
    }

    public int  insert(Student student){
        return studentMapper.insert(student);
    }

}
