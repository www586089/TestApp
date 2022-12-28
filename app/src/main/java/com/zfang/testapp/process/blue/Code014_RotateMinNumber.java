package com.zfang.testapp.process.blue;


import com.zfang.testapp.process.util.LogUtil;

/**
 * P27 旋转数组的最小数字(改造二分法)
 *
 *   把一个数组最开始的若干个元素搬到数组的末尾,我们称之为数组
 * 的旋转。
 *   输入一个递增排序的数组的一个旋转,输出旋转数组的最
 * 小元素。
 *   例如数组{3,4,5,1,2}为{1,2,3,4,5}的一 个旋转,该数组的
 * 最小值为1.
 */
public class Code014_RotateMinNumber {
    private static final Code014_RotateMinNumber app = new Code014_RotateMinNumber();

    /**
     * @param args
     */
    public static void main(String[] args) {
        app.result();
    }

    private void result() {
        int[] nums = new int[] {4, 5, 1, 2, 3};
        int result = findMinNumber(nums);
        LogUtil.print("result = " + result);
    }

    private int findMinNumber(int[] nums) {
        return 0;
    }
}
