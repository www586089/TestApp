package com.zfang.testapp.process.blue;


import com.zfang.testapp.process.util.LogUtil;

/**
 * P15 Shell排序
 */
public class Code012_ShellSort {
    private static final Code012_ShellSort app = new Code012_ShellSort();

    /**
     * @param args
     */
    public static void main(String[] args) {
        app.result();
    }

    private void result() {
        int[] nums1 = new int[] {7, 7, 7, 5, 4, 4, 4, 8, 8, 8};
        shellSort(nums1);
        printArray(nums1);

        nums1 = new int[] {1, 1, 1, 2, 2, 2, 3, 3, 3, 10, 10, 10, 100, 100, 100, 999, 999, 999, 1000001,
                1, 2, 3, 10, 100, 999
        };

        shellSort(nums1);
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
     * @param nums
     * @return
     */
    private void insertSort(int[] nums) {
        int N = nums.length;

        for (int interval = N / 2; interval > 0; interval = interval / 2) {
            for (int i = 1; i < N; i++) {
                int target = nums[i];
                int j = i - 1;
                while (j > -1 && target < nums[j]) {
                    nums[j + 1] = nums[j];
                    j--;
                }
                nums[j + 1] = target;
            }
        }
    }

    /**
     * @param nums
     * @return
     */
    private void shellSort(int[] nums) {
        int N = nums.length;

        for (int interval = N / 2; interval > 0; interval = interval / 2) {
            for (int i = interval; i < N; i++) {
                int target = nums[i];
                int j = i - interval;
                while (j > -1 && target < nums[j]) {
                    nums[j + interval] = nums[j];
                    j -= interval;
                }
                nums[j + interval] = target;
            }
        }
    }
}
