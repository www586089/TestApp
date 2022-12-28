package com.zfang.testapp.kotlin

class KConstructTest(val first: String, val second: Int) {


    init {
        println("KConstructTest init")
        test(1)
    }

    companion object CC {
        init {
            println("companion object init")
        }

        fun test(index: Int) {
            println("test, index = $index")
        }
    }
}