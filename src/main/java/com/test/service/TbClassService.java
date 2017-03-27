package com.test.service;

import com.test.model.TbClass;

import java.util.List;


/**
 * Created by 张宏浩 on 2017/3/1.
 */
public interface TbClassService {
    //根据年级id和班级姓名查找班级
    int judgeClass(int gradeId , String name);

    //根据班级id查找班级
    TbClass getById(int id);

    //插入班级
    int  insertClass(TbClass tbClass);

    //根据年级id查找所有班级
    List<TbClass> listByGraId(int graId);

    //根据关键字查找班级列表
    List<TbClass> listByKeyword(String keyword);

    //班级分页
    List<TbClass> selectByPage(int gradeId,int startPos,int pageSize);

    //班级总数
    int getCount(int gradeId);

    //关键字查找班级数量
    int getClassCount(int gradeId,String keyword);

    //关键字查找班级
    List<TbClass> selectClass(int gradeId,String keyword,int startPos,int pageSize);
}
