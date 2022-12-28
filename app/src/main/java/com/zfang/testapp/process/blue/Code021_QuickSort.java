package com.zfang.testapp.process.blue;


import com.zfang.testapp.process.util.LogUtil;

/**
 * P36 QuickSort 工程实践应用
 * 划分选取：
 * 1 三点中值法
 * 2 绝对中值法
 * 3 待排序列表较小时(<= 8)， 使用插入排序
 */
public class Code021_QuickSort {
    private static final Code021_QuickSort app = new Code021_QuickSort();

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
