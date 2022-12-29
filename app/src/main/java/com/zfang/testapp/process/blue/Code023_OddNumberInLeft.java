package com.zfang.testapp.process.blue;


import android.util.Log;

import com.zfang.testapp.process.util.LogUtil;

/**
 * P38 调整数组顺序---->使得奇数在左，偶数在右边
 */
public class Code023_OddNumberInLeft {
    private static final Code023_OddNumberInLeft app = new Code023_OddNumberInLeft();

    /**
     * @param args
     */
    public static void main(String[] args) {
        app.result();
    }

    private void result() {
        int[] nums = LogUtil.generateNums(10);//2, 36, 36, 25, 17, 24, 3, 22, 21, 5
        LogUtil.printArray(nums);
        adjust(nums);
        LogUtil.printArray(nums);
    }

    private void adjust(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            while (left <= right && (0 != nums[left] % 2)) left++;
            while (right >= left && (0 == nums[right] % 2)) right--;
            if (left <= right) {
                LogUtil.swap(nums, left, right);
            }
        }
    }
}
