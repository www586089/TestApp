package com.zfang.testapp.process.blue;


import android.util.Log;

import com.zfang.testapp.process.util.LogUtil;

/**
 * P16 汉诺塔问题
 */
public class Code010_Han {
    private static final Code010_Han app = new Code010_Han();

    private int index = 0;
    /**
     * @param args
     */
    public static void main(String[] args) {
        app.result();
    }

    /**
     * 将x个盘子从A移到B（借助C）等价格于
     * 1 将x-1个盘子从A移到C（借助B）
     * 2 将第x个盘子从A移到B
     * 3 将x-1个盘子从C移到B（借助A）
     */
    private void result() {
        move(4, 'A', 'B', 'C');
    }

    private void move(int x, char A, char B, char C) {
        if (1 == x) {
            LogUtil.println(++index + " Move " + x + "(" + A + ", " + B + ")");
            return;
        }
        move(x - 1, A, C, B);
        LogUtil.println(++index + " Move " + x + "(" + A + ", " + B + ")");
        move(x - 1, C, B, A);
    }
}
