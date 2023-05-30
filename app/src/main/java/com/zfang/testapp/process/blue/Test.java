package com.zfang.testapp.process.blue;

/**
 * @description:
 * @date: 2023/1/10 16:44
 * @author: zhangrifang
 */
public class Test {
    private static final Test test = new Test();


    public static Test getInstance() {
        return test;
    }

    public void setXXX(Book book) {
        book = null;
        System.out.println("after set null");
    }
}
