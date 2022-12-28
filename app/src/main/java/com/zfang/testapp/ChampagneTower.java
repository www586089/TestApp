package com.zfang.testapp;

/**
 * 香槟塔
 *    把玻璃杯摆成金字塔的形状，其中第一层有1个玻璃杯，第二层有2个，依次类推到第100层。
 *   从顶层的第一个玻璃杯开始倾倒一些香槟，当顶层的杯子满了，任何溢出的香槟都会立刻等流量的
 * 流向左右两侧的玻璃杯。当左右两边的杯子也满了，就会等流量的流向它们左右两边的杯子，依次
 * 类推。( 当最底层的玻璃杯满了，香槟会流到地板上)。
 *   例如，在倾倒一杯香槟后，最顶层的玻璃杯满了。倾倒了两杯香槟后，第二层的两个玻璃杯各自盛
 * 放一半的香槟。在倒三杯香槟后，第二层的香槟满了-此时总共有三个满的玻璃杯。在倒第四杯后
 * 第三层中间的玻璃杯盛放了一半的香槟，他两边的玻璃杯各自盛放了四分之一的香槟。
 *   现在当倾倒了非负整数杯香槟后，返回第i行j个玻璃杯所盛放的香槟占玻璃杯容积的比例（i和j都从0开始）。
 */
public class ChampagneTower {

    private static final ChampagneTower tower = new ChampagneTower();
    public static void main(String[] args) {
        double result = tower.champagneTower(5, 2, 2);
        System.out.println("result = " + result);
    }
    
    private double champagneTower(int poured, int row, int glass) {
        double[][] data = new double[100][100];
        data[0][0] = poured;

        for (int r = 0; r <= row; r++) {
            for (int l = 0; l <= r; l++) {
                double d = (data[r][l] - 1.0) / 2;
                if (d > 0) {
                    data[r + 1][l] += d;
                    data[r + 1][l + 1] +=d;
                }
            }
        }

        return Math.min(data[row][glass], 1);
    }
}
