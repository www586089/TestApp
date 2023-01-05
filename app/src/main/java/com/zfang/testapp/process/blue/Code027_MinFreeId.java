package com.zfang.testapp.process.blue;


import com.zfang.testapp.process.util.LogUtil;

import java.util.Arrays;

/**
 * P42 最小可用id
 */
public class Code027_MinFreeId {
    private static final Code027_MinFreeId app = new Code027_MinFreeId();

    /**
     * @param args
     */
    public static void main(String[] args) {
        app.result();
    }

    private void result() {
        int[] nums = new int[] {1, 2, 3, 6, 9, 10000};
        LogUtil.printArray(nums);

        int kNum = findMinFreeId(nums);
        LogUtil.println("find kNum = " + kNum);

        kNum = findMinFreeId2(nums);
        LogUtil.println("find kNum2 = " + kNum);
    }

    private int findMinFreeId(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        for (; index < nums.length; index++) {
            if (index + 1 != nums[index]) {
                return index + 1;
            }
        }

        return index + 1;
    }


    private int findMinFreeId2(int[] nums) {
        int n = nums.length;
        int[] helper = new int[n + 1];

        for (int index = 0; index < n; index++) {
            if (nums[index] < n + 1) {
                helper[nums[index]] = 1;
            }
        }

        for (int index = 1; index < n + 1; index++) {
            if (0 == helper[index]) {
                return index;
            }
        }

        return n + 1;
    }

}
