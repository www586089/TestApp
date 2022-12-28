package com.zfang.testapp.process.blue;

import android.util.Log;

import com.zfang.testapp.process.code.Code002_MaxSumLength;
import com.zfang.testapp.process.util.LogUtil;

import java.util.Random;

/**
 *
 * 1-1000这1000个数放在含有1001个元素的数组中，只有唯一一个元素值重复，其它均只出现1次。每个数组元素只能访问一
 * 次，设计一个算法，将它找出来;不用辅助存储空间，能否设计一
 * 个算法实现?
 */
public class Code001_RepetitionNum {
    private static final Code001_RepetitionNum app = new Code001_RepetitionNum();

    public static void main(String[] args) {
        int[] nums = app.generateNums(100);
        app.result(nums);
    }

    private int[] generateNums(int N) {
        int[] nums = new int[N + 1];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
            LogUtil.print(nums[i] + ", ");
        }
        nums[N] = random.nextInt(N) + 1;
        LogUtil.print(nums[N]);

        return nums;
    }

    private void result(int[] nums) {
        int result = findRepetitionNum(nums);
        LogUtil.println("\nresult = " + result);
    }

    /**
     * 把其余的数字变成重复的
     * @param nums
     * @return
     */
    private int findRepetitionNum(int[] nums) {
        int N = nums.length - 1;
        int result = 0;
        for (int i = 0; i < N; i++) {
            result ^= (i + 1);
        }

        for (int i = 0; i <= N; i++) {
            result ^= (nums[i]);
        }

        return result;
    }
}
