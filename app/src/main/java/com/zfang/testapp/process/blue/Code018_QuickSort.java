package com.zfang.testapp.process.blue;


import com.zfang.testapp.process.util.LogUtil;

/**
 * P33 QuickSort
 *
 */
public class Code018_QuickSort {
    private static final Code018_QuickSort app = new Code018_QuickSort();

    /**
     * @param args
     */
    public static void main(String[] args) {
        app.result();
    }

    private void result() {
        int[] nums = LogUtil.generateNums(20);
        LogUtil.printArray(nums);
        qSort(nums, 0, nums.length - 1);
        LogUtil.printArray(nums);
    }



    private void qSort(int[] nums, int begin, int end) {
        if (begin < end) {
            int qMiddle = partition(nums, begin, end);
            qSort(nums, begin, qMiddle - 1);
            qSort(nums, qMiddle + 1, end);
        }
    }

    /**
     * P33 -------> 单向扫描分区法
     * 把第一个元素做为划分主元，然后begin++，让begin指向主元的下一个元素，
     * end则指向数组的最后一个元素，然后让begin 或者end每次移动一步，保证
     * begin之前的元素都小于等于主元，end之后的元素都大于主元，当end大于begin
     * 的时候划分结束，此时end之前（index <= end）的元素都是小于等于主元的，
     * 交换主元与end之上的元素，取end为划分结果。
     * @param nums
     * @param begin
     * @param end
     * @return
     */
    private int partition(int[] nums, int begin, int end) {
        int pivot = begin++;
        while (begin <= end) {
            if (nums[pivot] >= nums[begin]) {
                begin++;
            } else {
                swap(nums, begin, end);
                end--;
            }
        }
        swap(nums, end, pivot);

        return end;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
