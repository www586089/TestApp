package com.zfang.testapp.process.blue;


import com.zfang.testapp.process.util.LogUtil;

/**
 * P35 QuickSort 三分法
 * 有与主元相同元素的数组排序，比如：
 * 2, -2, -1, ,1, 2, 5, 6, 2, 3, 2, 4, 2, 7, 2, 9, 2, 10
 * 以2为主元划分后形成如下数组：
 *         q                       r
 * -2, -1, 1, 2, 2, 2, 2, 2, 2, 2, 5, 6, 3, 4, 7, 9, 10
 * 此时下一步划分只需考虑q左边、r右边的部分，而无需考虑[q, r]之间的元素了
 */
public class Code020_QuickSort {
    private static final Code020_QuickSort app = new Code020_QuickSort();

    /**
     * @param args
     */
    public static void main(String[] args) {
        app.result();
    }

    private void result() {
        int[] nums = LogUtil.generateNums(400);
        LogUtil.printArray(nums);
        qSort(nums, 0, nums.length - 1);
        LogUtil.printArray(nums);
    }



    private void qSort(int[] nums, int begin, int end) {
        if (begin < end) {
            int[] qMiddle = partition(nums, begin, end);
            LogUtil.println("diff = " + (qMiddle[1] - qMiddle[0] + 1));
            qSort(nums, begin, qMiddle[0] - 1);
            qSort(nums, qMiddle[1] + 1, end);
        }
    }

    /**
     * P35 -------> 三分扫描分区法
     * @param nums
     * @param begin
     * @param end
     * @return
     */
    private int[] partition(int[] nums, int begin, int end) {
        int e = begin + 1;//等于主元开始的索引
        int s = begin + 1;//等于主元结束的索引
        int pivot = begin;//主元索引
        while (s <= end) {
            //end指针定位到第一个小于主元的元素
            while (s <= end && nums[end] > nums[pivot]) end--;
            //扩展[e, s]区间，找到第一个大于主元的元素结束循环.
            while (s <= end) {
                if (nums[s] == nums[pivot]) {
                    s++;
                } else if (nums[s] < nums[pivot]) {
                    LogUtil.swap2(nums, s, e);
                    e++;
                    s++;
                } else {
                    break;
                }
            }

            if (s < end) {
                LogUtil.swap2(nums, s, end);
            }
        }

        LogUtil.swap2(nums, begin, e - 1);
        return new int[]{e, end};
    }
}
