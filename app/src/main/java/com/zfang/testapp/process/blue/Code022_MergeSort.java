package com.zfang.testapp.process.blue;


import android.util.Log;

import com.zfang.testapp.process.util.LogUtil;

/**
 * P37 MergeSort
 */
public class Code022_MergeSort {
    private static final Code022_MergeSort app = new Code022_MergeSort();

    /**
     * @param args
     */
    public static void main(String[] args) {
        app.result();
    }

    private void result() {
        int[] nums = LogUtil.generateNums(10);
        LogUtil.printArray(nums);
        mergeSort2(nums, 0, nums.length - 1);
        LogUtil.printArray(nums);
    }

    private void mergeSort2(int[] nums, int begin, int end) {
        if (begin < end) {
            int middle = (begin + end) >> 1;
            mergeSort2(nums, begin, middle);
            mergeSort2(nums, middle + 1, end);
            merge(nums, begin, middle, end);
        }
    }


    /**
     * todo has bug to fix
     * @param nums
     * @param begin
     * @param end
     */
    private void sort(int[] nums, int begin, int end) {
        int N = (end - begin + 1);
        int l = 1;
        int index;
        for (; l <= N / 2; l += l) {
            index = 0;
            while (index <= end - 2 * l) {
                merge(nums, index, index + l - 1, index + 2 * l - 1);
                index += 2 * l;
            }
            if (index + l > end) {
                merge(nums, 0, index - 1, end);
            } else if (index + 2 * l < end && index < end) {
                merge(nums, index, index + l - 1, end);
            }
            if (l + l > N / 2) {
                break;
            }
        }

        if (l + l > N / 2) {
            merge(nums, 0, l - 1, end);
        }
    }

    /**
     *
     * 合并区间[p, q] (q, r]
     * @param nums
     * @param p
     * @param q
     * @param r
     */
    private void merge(int[] nums, int p, int q, int r) {
        int[] mergeArray = new int[r - p + 1];

        int lLength = q - p + 1;
        int rLength = r - q;
        int length = rLength + lLength;
        LogUtil.println("p = " + p + ", q = " + q + ", r = " + r + ", lLength = " + lLength + ", rLength = " + rLength);
        int index = 0;
        int i = 0, j = 0;
        while (i < lLength && j < rLength) {
            if (nums[p + i] <= nums[q + 1 + j]) {
                mergeArray[index++] = nums[p + i++];
            } else {
                mergeArray[index++] = nums[q + 1 + j++];
            }
        }
        while (i < lLength) {
            mergeArray[index++] = nums[p + i++];
        }
        while (j < rLength) {
            mergeArray[index++] = nums[q + 1 + j++];
        }

        if (length > 0) System.arraycopy(mergeArray, 0, nums, p, length);
    }
}
