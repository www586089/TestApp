package com.zfang.testapp;

/**
 * 打家劫舍（一）----> 111
 *   你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有定的现金， 影响你偷窃的唯一制约
 * 因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统
 * 会自动报警。
 *   给定一个代表每个房屋存放金额的非负整数数组，计算你不触动警报装置的情况下，一夜之内能够
 * 偷窃到的最高金额。
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 输入: [2,7,9,3,1]
 * 输出: 12
 */
public class Rob {

    private static Rob app = new Rob();
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 1};
        int[] nums2 = new int[]{2, 7, 9, 3, 1};
        app.result(nums1, nums1.length - 1);
        app.result(nums2, nums2.length - 1);

        app.resultDp(nums1, nums1.length - 1);
        app.resultDp(nums2, nums2.length - 1);
    }

    private <T> void log(T info) {
        System.out.println(info);
    }

    private void result(int[] nums, int index) {
        int maxMoney = maxMoney(nums, index);

        log("maxMoney = " + maxMoney);
    }

    private void resultDp(int[] nums, int index) {
        int maxMoney = maxMoneyDp(nums, index);

        log("maxMoneyDp = " + maxMoney);
    }

    private int maxMoney(int[] nums, int index) {
        if (nums == null || index < 0) {
            return 0;
        }
        if (0 == index) {
            return nums[0];
        }

        return Math.max(maxMoney(nums, index - 1), maxMoney(nums, index - 2) + nums[index]);
    }

    private int maxMoneyDp(int[] nums, int index) {
        if (index < 0) {
            return 0;
        }
        if (0 == index) {
            return nums[0];
        }
        int[] dp = new int[index + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i <= index; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[index];
    }
}
