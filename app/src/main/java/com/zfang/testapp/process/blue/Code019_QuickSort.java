package com.zfang.testapp.process.blue;


import com.zfang.testapp.process.util.LogUtil;

/**
 * P34 QuickSort 双向扫描分区法
 *
 */
public class Code019_QuickSort {
    private static final Code019_QuickSort app = new Code019_QuickSort();

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
     * P34 -------> 双向扫描分区法
     * 双向扫描的思路是,头尾指针往中间扫描,从左找到大于主元的元
     * 素,从右找到小于等于主元的元素二者交换,继续扫描,直到左侧
     * 无大元素,右侧无小元素
     * @param nums
     * @param begin
     * @param end
     * @return
     */
    private int partition(int[] nums, int begin, int end) {
        int pivot = begin++;
        while (begin <= end) {
            while (begin <= end && nums[begin] <= nums[pivot]) begin++;
            while (begin <= end && nums[end] > nums[pivot]) end--;
            if (begin < end) {
                swap(nums, begin, end);
            }
        }

        swap(nums, pivot, end);
        return end;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
