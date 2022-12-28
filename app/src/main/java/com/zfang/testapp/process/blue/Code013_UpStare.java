package com.zfang.testapp.process.blue;


import com.zfang.testapp.process.util.LogUtil;

/**
 * P26 爬楼梯
 *
 *   小白正在上楼梯,楼梯有n阶台阶,小白一次可以上1阶, 2阶或者
 * 3阶,实现一个方法,计算小白有多少种走完楼梯的方式。
 */
public class Code013_UpStare {
    private static final Code013_UpStare app = new Code013_UpStare();

    /**
     * @param args
     */
    public static void main(String[] args) {
        app.result();
    }

    private void result() {
        int result = stareCount(4);
        LogUtil.print("result = " + result);
    }

    private int stareCount(int N) {
        switch (N) {
            case 0:
            case 1:
                return 1;
            case 2:
                return 2;
        }

        return stareCount(N - 1) + stareCount(N - 2) + stareCount(N - 3);
    }
}
