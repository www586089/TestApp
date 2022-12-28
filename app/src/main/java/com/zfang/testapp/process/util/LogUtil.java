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
}
