package com.zfang.testapp.process.blue;


import com.zfang.testapp.process.util.LogUtil;

/**
 * P7 位运算思想：将一个整数的奇偶位交换
 * 将一个整数的奇偶位交换
 */
public class Code005_NumberSwap {
    private static final Code005_NumberSwap app = new Code005_NumberSwap();

    public static void main(String[] args) {
        app.result();
    }

    private void result() {
        int result = numberSwap(9);
        LogUtil.println("result1 = " + result);

        result = numberSwap(16);
        LogUtil.println("result2 = " + result);

        result = numberSwap(0);
        LogUtil.println("result3 = " + result);
    }

    /**
     * 1
     * xyxy xyxy & 0101 0101 = 0y0y 0y0y
     * xyxy xyxy & 1010 1010 = x0x0 x0x0
     *
     * 2
     * 0y0y 0y0y << 1 -> y0y0 y0y0
     * x0x0 x0x0 >> 1 -> 0x0x 0x0x
     *
     * 3
     * y0y0 y0y0 ^ 0x0x 0x0x = yxyx yxyx
     * @param x
     * @return
     */
    private int numberSwap(int x) {
        int ji = 0x55555555 & x;
        int ou = 0xaaaaaaaa & x;

        return (ou >> 1) ^ (ji << 1);
    }
}
