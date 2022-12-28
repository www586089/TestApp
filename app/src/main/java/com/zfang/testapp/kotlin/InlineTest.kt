package com.zfang.testapp.kotlin

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

class InlineTest {
    private fun byteSizeForUnsigned(maxValue: Long): Int {
        var value = maxValue
        var byteCount = 0
        while (value != 0L) {
            value = value shr 8
            byteCount++
        }
        return byteCount
    }

    private fun testShr() {
        println("1024 shr 1 = " + (1024 shr 1))
        println("1024 shr 2 = " + (1024 shr 2))
        println("1024 shr 3 = " + (1024 shr 3))
        println("1024 shr 4 = " + (1024 shr 4))
        println("1024 shr 5 = " + (1024 shr 5))
        println("1024 shr 6 = " + (1024 shr 6))
        println("1024 shr 7 = " + (1024 shr 7))
        println("1024 shr 8 = " + (1024 shr 8))
        println("1024 shr 9 = " + (1024 shr 9))
        println("1024 shr 10 = " + (1024 shr 10))

        println("0 shr 2 = " + (0 shr 2))
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val test = InlineTest()
            //24647
            var result = test.byteSizeForUnsigned(24647)
            println("result = $result")
            test.testShr()
        }
    }

    private var boo: Int = 0
    get() = field
    set(value: Int) {
        field = value
    }

    inline fun f(crossinline body: () -> Unit) {
        val f = object: Runnable {
            override fun run() = body()
        }
        // ...
    }
    private fun test() {
        lock(ReentrantLock()) {
            foo()
        }
    }
    private fun foo() {
        println("run foo")
    }
    private inline fun <T> lock(lock: Lock, body: () -> T): T? {
        try {
            lock.lock()
            return body.invoke()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            lock.unlock()
        }

        return null
    }
}