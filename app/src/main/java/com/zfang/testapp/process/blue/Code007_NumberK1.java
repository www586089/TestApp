package com.zfang.testapp.process.blue;


import com.zfang.testapp.process.util.LogUtil;

/**
 * P9, P10 编程实践:出现k次与出现1次(上)
 * 数组中只有一个数出现了1次，其他的数都出现了k次，请输出只
 * 出现了1次的数。
 */
public class Code007_NumberK1 {
    private static final Code007_NumberK1 app = new Code007_NumberK1();

    /**
     * 在不进位加法中，K进制的数加了K次后就变成0
     * 比如10进制中，9加了10次后变成90，但是不进位，所以就只有个位的0。
     * @param args
     */
    public static void main(String[] args) {
        app.result();
    }

    private void result() {
        int[] nums1 = new int[] {7, 7, 7, 5, 4, 4, 4, 8, 8, 8};
        int result = find1Once(nums1, 3);
        LogUtil.println("result1 = " + result);

        nums1 = new int[] {22, 22, 55, 55, 22, 55, 100000, 18, 18, 18, 99, 99, 99};
        result = find1Once(nums1, 3);
        LogUtil.println("result2 = " + result);

        nums1 = new int[] {1, 1, 1, 2, 2, 2, 3, 3, 3, 10, 10, 10, 100, 100, 100, 999, 999, 999, 1000001,
                1, 2, 3, 10, 100, 999
        };
        result = find1Once(nums1, 4);
        LogUtil.println("result3 = " + result);
    }

    /**
     *
     * @param nums
     * @return
     */
    private int find1Once(int[] nums, int k) {
        int N = nums.length;
        String[] numStr = new String[N];
        StringBuilder sb = new StringBuilder();
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            sb.delete(0, sb.length());
            String radixInfo = sb.append(Integer.toString(nums[i], k)).reverse().toString();
            if (radixInfo.length() > maxLength) {
                maxLength = radixInfo.length();
            }
            numStr[i] = radixInfo;
        }
        int[] resultArray = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < N; j++) {
                if (numStr[j].length() > i) {
                    resultArray[i] += numStr[j].charAt(i) - '0';
                }
            }
        }

        int result = 0;
        for (int i = 0; i < maxLength; i++) {
            result += (resultArray[i] % k) * Math.pow(k, i);
        }

        return result;
    }
}
