package com.zfang.testapp.process.util;

import java.util.Random;

public class LogUtil {
    public  static <T> void println(T info) {
        System.out.println(info);
    }

    public  static <T> void print(T info) {
        System.out.print(info);
    }

    public static void newLine() {
        System.out.println();
    }

    public static void printArray(int[] array) {
        for (int t : array) {
            print(t + ", ");
        }
        newLine();
    }

    public static int[] generateNums(int N) {
        int[] nums = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            nums[i] = random.nextInt(50) + 1;
        }

        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    public static void swap2(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
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
    public static int partition(int[] nums, int begin, int end) {
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
