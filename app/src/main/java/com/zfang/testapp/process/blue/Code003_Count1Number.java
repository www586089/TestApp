package com.zfang.testapp.process.blue;


import com.zfang.testapp.process.util.LogUtil;

/**
 * P5
 * 请实现一一个函数，输入一个整数，输出该数二进制表示中1的个数。
 * 例: 9的二进制表示为1001，有2位是1
 */
public class Code003_Count1Number {
    private static final Code003_Count1Number app = new Code003_Count1Number();

    public static void main(String[] args) {
        app.result(15);
    }

    private void result(int x) {
        int result = count1Number(x);
        LogUtil.println("result1 = " + result);

        result = count1Number2(x);
        LogUtil.println("result2 = " + result);

        result = count1Number3(x);
        LogUtil.println("result3 = " + result);
    }
    private int count1Number3(int x) {
        int count = 0;
        while (1 == (1 & x)) {
            count++;
            x >>= 1;
        }

        return count;
    }

    /**
     * 1左移再与原数相 与 运算
     * @param x
     * @return
     */
    private int count1Number2(int x) {
        int count = 0;
        for (int i = 0; i < 32 ; i++) {
            if ((1 << i) == ((1 << i) & x)) {
                count++;
            }
        }

        return count;
    }

    /**
     * 1001 1101    ->(-1) 1001 1100
     * @param x
     * @return
     */
    private int count1Number(int x) {
        int count = 0;
        while (0 != x) {
            x = x & (x - 1);
            count++;
        }
        return count;
    }
}
