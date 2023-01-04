package com.zfang.testapp.process.blue;


import static com.zfang.testapp.process.util.LogUtil.swap;

import com.zfang.testapp.process.util.LogUtil;

/**
 * P39 从一个乱序数组中找到第k小的数
 */
public class Code024_SelectK {
    private static final Code024_SelectK app = new Code024_SelectK();

    /**
     * @param args
     */
    public static void main(String[] args) {
        app.result();
    }

    private void result() {
        int[] nums = LogUtil.generateNums(10);//2, 36, 36, 25, 17, 24, 3, 22, 21, 5
        LogUtil.printArray(nums);
        int kNum = selectK(nums, 0, nums.length - 1, 3);
        LogUtil.print(kNum);
    }

    private int selectK(int[] nums, int p, int r, int k) {
        int q = partition(nums, p, r);
        int qK = q - p + 1;
        if (qK == k) {
            return nums[q];
        } else if (qK > k) {
            return selectK(nums, p, qK, k);
        } else {
            return selectK(nums, q + 1, r, k - qK);
        }
    }

    /**
     *  单向扫描分区法
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
}
