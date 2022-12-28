package com.zfang.testapp.process.blue;

import com.zfang.testapp.process.util.LogUtil;

/**
 * 一个数组里除了某一个数字之外，其他的数字都出现了两次。请写
 * 程序找出这个只出现一次的数字。
 */
public class Code002_SingleNumber {
    private static final Code002_SingleNumber app = new Code002_SingleNumber();

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 3, 5, 5, 3, 100, 233, 233, 100, 99};
        app.result(nums);
    }

    private void result(int[] nums) {
        int result = findSingleNum(nums);
        LogUtil.println("result = " + result);
    }

    /**
     * xor 运算会去掉重复的数据
     * @param nums
     * @return
     */
    private int findSingleNum(int[] nums) {
        int N = nums.length - 1;
        int result = 0;

        for (int i = 0; i <= N; i++) {
            result ^= (nums[i]);
        }

        return result;
    }
}
