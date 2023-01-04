package com.zfang.testapp.process.blue;


import static com.zfang.testapp.process.util.LogUtil.partition;

import com.zfang.testapp.process.util.LogUtil;

import java.util.Arrays;

/**
 * P41 哪个数字刚好一半
 */
public class Code026_findTheHalfNumber2 {
    private static final Code026_findTheHalfNumber2 app = new Code026_findTheHalfNumber2();

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
        LogUtil.println("find kNum = " + kNum);
    }



    private int findNumber(int[] nums) {
        int lastNum = nums[nums.length - 1];
        int countOfLast = 0;

        int count = 1;
        int candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (lastNum == nums[i]) {
                countOfLast++;
            }
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

        if (countOfLast == nums.length / 2) {
            return lastNum;
        } else {
            return candidate;
        }
    }
}
