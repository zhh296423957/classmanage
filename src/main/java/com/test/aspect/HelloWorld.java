package com.test.aspect;


/**
 * Created by 张宏浩 on 2017/3/10.
 */
public class HelloWorld {
    public void sayHello(){
        System.out.println("hello world!");
    }

    public static void main(String[] args){
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
    }
}
