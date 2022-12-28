package com.zfang.testapp.process.blue;


import com.zfang.testapp.process.util.LogUtil;

/**
 * P14 求最大公约数
 */
public class Code008_GCD {
    private static final Code008_GCD app = new Code008_GCD();

    /**
     * @param args
     */
    public static void main(String[] args) {
        app.result();
    }

    private void result() {
        int result = gcd(24, 18);
        LogUtil.println("result1 = " + result);

        result = gcd(49, 3);
        LogUtil.println("result2 = " + result);

        result = gcd(35, 7);
        LogUtil.println("result3 = " + result);
    }

    /**
     * m > n
     * @param m
     * @param n
     * @return
     */
    private int gcd(int m, int n) {
        if (0 == n) {
            return m;
        }
        return gcd(n, m % n);
    }
}
