package com.zfang.testapp;

import java.util.LinkedList;
import java.util.Queue;

public class GroupMerge {
    /**
     * 99-> 102
     * 省份数量
     * 描述：有n个城市，其中一些彼此相连，另一些没有相连。如果城市A与城市B直接相连，且城市B与城市C直接相连，那么城市A与城市C间接相连。
     * 省份是一组直接或间接相连的城市，组内不含其他没有相连的城市。
     * 给你一个nXn的矩阵isConnected，其中isConnected[ilj]= 1表示第i个城市和第j个城市直接相连，而isConnected[i][i] = 0
     * 表示 二者不直接相连。
     * 问题：返回矩阵中省份的数量。
     * 扩展:朋友圈问题，亲戚问题
     * @param args
     */
    public static void main(String[] args) {

        GroupMerge app = new GroupMerge();
        int[][] city1 = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] city2 = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int provinceCount;

        provinceCount = app.getProvinceDFS(city1);
        app.log("DFS--->provinceCount = " + provinceCount);
        provinceCount = app.getProvinceDFS(city2);
        app.log("DFS--->provinceCount = " + provinceCount);

        provinceCount = app.getProvinceBFS(city1);
        app.log("BFS--->provinceCount = " + provinceCount);
        provinceCount = app.getProvinceBFS(city2);
        app.log("BFS--->provinceCount = " + provinceCount);

        app.mergeFind(city1);
        app.mergeFind(city2);
    }

    private <T> void log(T t) {
        System.out.println(t);
    }

    private int getProvinceDFS(int[][] cityConnected) {
        int length = cityConnected.length;
        int[] visited = new int[length];
        int provinceCount = 0;
        for (int i = 0; i < length; i++) {
            if (0 == visited[i]) {
                provinceCount++;
                dfs(i, cityConnected, length, visited);
            }
        }

        return provinceCount;
    }

    /**
     * 从节点i开始深度优先遍历能够访问到的节点。
     * @param i               从节点i开始
     * @param cityConnected   城市数组
     * @param length          城市数量
     * @param visited         标识数组
     */
    private void dfs(int i, int[][] cityConnected, int length, int[] visited) {
        for (int j = 0; j < length; j++) {
            if (1 == cityConnected[i][j] && 1 != visited[j]) {
                visited[j] = 1;
                dfs(j, cityConnected, length, visited);
            }
        }
    }


    private int getProvinceBFS(int[][] cityConnected) {
        int length = cityConnected.length;
        int[] visited = new int[length];
        int provinceCount = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (0 == visited[i]) {
                queue.offer(i);
                /**
                 * 从当前节点以广度优先遍历能够访问到的节点，访问不到的说明没有与当前节点
                 * 直接或者间接接连。
                 */
                while (!queue.isEmpty()) {
                    Integer j = queue.poll();
                    if (null == j) continue;
                    visited[j] = 1;
                    for (int k = 0; k < length; k++) {
                        if (1 == cityConnected[j][k] && 1 != visited[k]) {
                            queue.offer(k);
                        }
                    }
                }
                provinceCount++;
            }
        }

        return provinceCount;
    }

    private void mergeFind(int[][] cityConnected) {
        int provinces = cityConnected.length;
        int[] head = new int[provinces];
        int[] level = new int[provinces];

        for (int i = 0; i < provinces; i++) {
            head[i] = i;
            level[i] = 1;
        }

        for (int i = 0; i < provinces; i++) {
            for (int j = i + 1; j < provinces; j++) {
                if (1 == cityConnected[i][j]) {
                    mergeTree(i, j + 1, level, head);
                }
            }
        }

        int provinceCount = 0;
        for (int i = 0; i < provinces; i++) {
            if (i == head[i]) {
                provinceCount++;
            }
        }

        log("并查集--->provinceCount = " + provinceCount);
    }

    private void mergeTree(int x, int y, int[] level, int[] head) {
        int xRoot = findRoot(x, head);
        int yRoot = findRoot(y, head);
        //是同一颗树
        if (xRoot == yRoot) {
            return;
        }
        //合并树
        if (level[x] <= level[y]) {
            head[x] = y;
        } else {
            head[y] = x;
        }
        //修改层深度
        if (level[x] == level[y]) {
            level[x] += 1;
            level[y] += 1;
        }
    }

    private int findRoot(int i, int[] head) {
        if (i == head[i]) {
            return i;
        }
        head[i] = findRoot(head[i], head);

        return head[i];
    }
}
