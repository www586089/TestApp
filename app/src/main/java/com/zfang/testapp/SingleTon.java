package com.zfang.testapp;

import com.zfang.testapp.kotlin.KConstructTest;

class Test {
    public static void main(String[] args) {
        KConstructTest test = new KConstructTest("ttt", 1);
        KConstructTest.CC cc = test.CC;
    }
}
