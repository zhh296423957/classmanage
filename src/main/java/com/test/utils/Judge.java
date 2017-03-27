package com.test.utils;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.transaction.Transactional;

/**
 * Created by 张宏浩 on 2017/3/1.
 */
@ContextConfiguration(locations = {"classpath*:spring-*.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class Judge {


    public int judgeSchool(String name){

        return 0;
    }

}
