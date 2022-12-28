package com.zfang.testapp.process.code;

import com.zfang.testapp.process.util.LogUtil;

import java.util.HashMap;
import java.util.Map;

public class Code002_MaxSumLength {
    private static final Code002_MaxSumLength app = new Code002_MaxSumLength();

    public static void main(String[] args) {
        int[] nums = new int[] {1, -1, 3, 3, 0};
        app.result(nums, 6);
    }

    private void result(int[] nums, int target) {
        int result = maxSumLength(nums, target);
        LogUtil.println(result);
    }

    private int maxSumLength(int[] nums, int target) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // important

        int result = -1;
        int sum = 0;
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
            if (map.containsValue(sum - target)) {
                /*
                 * 0...17 -> 1000 target = 300
                 * 0...4  -> 700
                 * 5...17 -> 300
                 * length = 17 - 4
                 */
                result = Math.max(i - map.get(sum - target), result);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return result;
    }
}
