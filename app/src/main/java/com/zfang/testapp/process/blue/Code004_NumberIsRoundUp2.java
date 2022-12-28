package com.zfang.testapp.process.blue;


import com.zfang.testapp.process.util.LogUtil;

/**
 * P6
 * 判断一个整数是否为2的整数次方
 */
public class Code004_NumberIsRoundUp2 {
    private static final Code004_NumberIsRoundUp2 app = new Code004_NumberIsRoundUp2();

    public static void main(String[] args) {
        app.result();
    }

    private void result() {
        boolean result = isRoundUp2(15);
        LogUtil.println("result1 = " + result);

        result = isRoundUp2(16);
        LogUtil.println("result2 = " + result);

        result = isRoundUp2(0);
        LogUtil.println("result3 = " + result);
    }

    /**
     * 1001 1101    ->(-1) 1001 1100
     * @param x
     * @return
     */
    private boolean isRoundUp2(int x) {
        return 0 == (x & (x - 1));
    }
}
