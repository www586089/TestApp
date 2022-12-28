package com.zfang.testapp;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/** 115
 * 优势洗牌
 * 给定两个大小相等的数组A和B, A相对于B的优势可以用满足A[i]> B[i]的索引i的数目来描
 * 述。
 * 返回A的任意排列，使其相对于B的优势最大化。
 */
public class HorseRacing115 {
    private static final HorseRacing115 app = new HorseRacing115();
    public static void main(String[] args) {
        int[] A = new int[] {10, 24, 8, 32};
        int[] B = new int[] {13, 25, 25, 11};
        app.result(A, B);
    }

    private void result(int[] A, int[] B) {
        int[] result = advantageCount(A, B);
        for (int i : result) {
            log(i);
        }
    }
    private <T> void log(T info) {
        System.out.println(info);
    }

    private int[] advantageCount(int[] A, int[] B) {
        int[] sortB = B.clone();
        Arrays.sort(sortB);
        Arrays.sort(A);

        Map<Integer, Deque<Integer>> bMap = new HashMap<>();
        for (int b: B) {
            bMap.put(b, new LinkedList<>());
        }

        Deque<Integer> aQueue = new LinkedList<>();
        int j = 0;
        for (int a: A) {
            if (a > sortB[j]) {
                bMap.get(sortB[j++]).add(a);
            } else {
                aQueue.add(a);
            }
        }

        int[] result = new int[A.length];

        for (int i = 0; i < B.length; i++) {
            if (bMap.get(B[i]).size() > 0) {
                result[i] = bMap.get(B[i]).removeLast();
            } else {
                result[i] = aQueue.removeLast();
            }
        }

        return result;
    }
}
