package com.zfang.testapp.process.blue;


import static com.zfang.testapp.process.util.LogUtil.partition;

import android.util.Log;

import com.zfang.testapp.process.util.LogUtil;

import java.util.Arrays;

/**
 * P40 哪个数字超过了一半
 */
public class Code025_findTheHalfNumber {
    private static final Code025_findTheHalfNumber app = new Code025_findTheHalfNumber();

    /**
     * @param args
     */
    public static void main(String[] args) {
        app.result();
    }

    private void result() {
        int[] nums = new int[] {1, 2, 3, 8, 8, 7, 8, 8, 8};
        LogUtil.printArray(nums);
        int kNum = findNumber(nums);
        LogUtil.println("selectK kNum = " + kNum);

        Arrays.sort(nums);
        kNum = nums[nums.length / 2];
        LogUtil.println("sort kNum = " + kNum);

        kNum = findNumber2(nums);
        LogUtil.println("find kNum = " + kNum);
    }



    private int findNumber(int[] nums) {
        LogUtil.println("half num index = " + nums.length / 2);
        return selectK(nums, 0, nums.length - 1, nums.length / 2 + 1);
    }

    private int findNumber2(int[] nums) {
        int count = 1;
        int candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (0 == count) {
                candidate = nums[i];
                count = 1;
                continue;
            }
            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    private int selectK(int[] nums, int p, int r, int k) {
        int q = partition(nums, p, r);
        int qK = q - p + 1;
        if (qK == k) {
            return nums[q];
        } else if (qK > k) {
            return selectK(nums, p, q - 1, k);
        } else {
            return selectK(nums, q + 1, r, k - qK);
        }
    }
}
