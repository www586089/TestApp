package com.zfang.testapp.process.blue;


import android.util.Log;

import com.zfang.testapp.process.util.LogUtil;

/**
 * P15 插入排序
 */
public class Code009_InsertSort {
    private static final Code009_InsertSort app = new Code009_InsertSort();

    /**
     * @param args
     */
    public static void main(String[] args) {
        app.result();
    }

    private void result() {
        int[] nums1 = new int[] {7, 7, 7, 5, 4, 4, 4, 8, 8, 8};
        insertSort(nums1, nums1.length - 1);
        printArray(nums1);

        nums1 = new int[] {1, 1, 1, 2, 2, 2, 3, 3, 3, 10, 10, 10, 100, 100, 100, 999, 999, 999, 1000001,
                1, 2, 3, 10, 100, 999
        };

        insertSort(nums1, nums1.length - 1);
        printArray(nums1);
    }

    private void printArray(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            LogUtil.print(nums[i] + ", ");
        }
        LogUtil.newLine();
    }

    /**
     * m > n
     * @param nums
     * @return
     */
    private void insertSort(int[] nums, int k) {
        if (0 == k) {
            return;
        }
        insertSort(nums, k - 1);
        int x = nums[k];
        int index = k - 1;
        while (index >= 0 && x < nums[index]) {
            nums[index + 1] = nums[index];
            index--;
        }
        nums[index + 1] = x;
    }
}
