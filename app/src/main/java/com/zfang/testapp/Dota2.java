package com.zfang.testapp;

import java.util.LinkedList;
import java.util.Queue;


/** 114
 * Dota2参议院
 *   Dota2的世界里有两个阵营: Radiant( 天辉)和Dire(夜魇)
 * Dota2参议院由来自两派的参议员组成。现在参议院希望对一个Dota2游戏里的改变作出决定。他
 * 们以一个基于轮为过程的投票进行。在每轮中，每一位参议员都可以行使两项权利中的一项:
 *   禁止一名参议员的权利:参议员可以让另一位参议员在这一轮和随后的几轮中丧失所有的权利。
 *   宣布胜利:如果参议员发现有权利投票的参议员都是同一个阵营的，他可以宣布胜利并决定在游戏
 * 中的有关变化。
 *   给定一个字符串代表每个参议员的阵营。字母“R”和“D”分别代表了Radiant (天辉)和Dire (夜魇)。
 * 然后，如果有n个参议员，给定字符串的大小将是n。
 *   以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这过程将持续到投票
 * 结束。所有失去权利的参议员将在过程中被跳过。
 *   假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪-方最终会宣布胜
 * 利并在Dota2游戏中决定改变。输出应该是Radiant或Dire
 */
public class Dota2 {

    private static final Dota2 app = new Dota2();
    public static void main(String[] args) {
        app.result("DRR");
    }

    private void result(String senate) {
        log(predictPartyVictory(senate));
    }


    private String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        int length = senate.length();
        for (int i = 0; i < length; i++) {
            if ('R' == senate.charAt(i)) {
                r.offer(i);
            } else {
                d.offer(i);
            }
        }

        while (!r.isEmpty() && !d.isEmpty()) {
            int rPoll = r.poll();
            int dPoll = d.poll();
            if (rPoll < dPoll) {
                r.offer(rPoll + length); //R进入下一轮
            } else {
                d.offer(dPoll + length);
            }
        }

        return d.isEmpty() ? "R" : "D";
    }

    private <T> void log(T info) {
        System.out.println(info);
    }
}
