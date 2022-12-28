package com.zfang.testapp.process.blue;


import com.zfang.testapp.process.util.LogUtil;

/**
 * P17 二分查找
 */
public class Code011_FindTwo {
    private static final Code011_FindTwo app = new Code011_FindTwo();

    private int index = 0;
    /**
     * @param args
     */
    public static void main(String[] args) {
        app.result();
    }

    private void result() {
        int[] nums = new int[] {0, 1, 3, 4, 5, 7, 9, 12, 16, 18, 20, 38, 40, 41, 42, 100};
        int result = find(nums, 0, nums.length - 1, 20);
        LogUtil.println("result = " + result);
    }

    private int find(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int middle = (low + high) >> 1;
        int key = nums[middle];
        if (target < key) {
            return find(nums, low, middle - 1, target);
        } else if (target > key) {
            return find(nums, middle + 1, high, target);
        } else {
            return middle;
        }
    }
}
