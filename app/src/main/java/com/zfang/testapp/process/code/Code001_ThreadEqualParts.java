package com.zfang.testapp.process.code;

import android.util.Log;

import com.zfang.testapp.process.util.LogUtil;

/**
 * leetCode 927
 */
public class Code001_ThreadEqualParts {

    private static final Code001_ThreadEqualParts app = new Code001_ThreadEqualParts();

    public static void main(String[] args) {
        int[] nums = new int[] {1, 0, 1, 0, 1};
        app.result(nums);
    }

    private void result(int[] nums) {
        int[] result = partion(nums);
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
            if (i == result.length - 1) {
                sb.append("]");
            } else {
                sb.append(", ");
            }
        }
        LogUtil.println(sb.toString());
    }

    private int[] partion(int[] nums) {
        int count = 0;
        int N = nums.length;
        for (int num : nums) {
            if (1 == num) {
                count++;
            }
        }
        if (0 != (count % 3)) {
            return new int[] {-1, -1};
        }
        if (0 == count) {
            return new int[] {0, N - 1};
        }

        int start1 = -1;
        int start2 = -1;
        int start3 = -1;
        int part = count / 3;
        count = 0;
        for (int i = 0; i < N; i++) {
            if (1 == nums[i]) {
                count++;
                if (-1 == start1) {
                    start1 = i;
                }
                if (-1 == start2 && count == (part + 1)) {
                    start2 = i;
                }
                if (-1 == start3 && count == (2 * part + 1)) {
                    start3 = i;
                }
            }
        }

        while (start3 < N) {
            if (nums[start1] != nums[start2] || nums[start1] != nums[start3] || nums[start2] != nums[start3]) {
                return new int[] {-1, -1};
            }
            start1++;
            start2++;
            start3++;
        }

        return new int[] {start1 - 1, start2};
    }
}
