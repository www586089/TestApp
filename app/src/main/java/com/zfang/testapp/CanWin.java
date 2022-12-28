package com.zfang.testapp;


/**
 * 103 104
 * 预测赢家
 * 给定一个表示分数的非负整数数组。玩家1从数组任意一端拿取一个分数，随后玩家2继续从剩余数组任意一端拿取
 * 分数， 然后玩家1拿，、、、。每次一个玩家只 能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数
 * 可取时游戏结束。最终获得分数总和最多的玩家获胜。
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 * 扩展：投石游戏
 */
public class CanWin {

    /**
     * {5, 200, 1, 3, 6}
     * player1 {5, 6}(先手)
     *     5 {1, 6} 1 3 [5 + 1 + 3 = 9]
     *     5 {1, 6} 6 1 [5 + 6 + 1 = 12]
     *     6 {5, 1} 5 1 [6 + 5 + 1 = 12]
     *     6 {5, 1} 1 5 [6 + 1 + 5 = 12]
     *
     * player2 {5, 3}(后手)
     *     3 200 [3 + 200 = 203]
     *     5 3   [5 + 3   = 8 ]
     * [left ... right]
     *  1 left = right
     *      score = scores[left]
     *  2 right - left = 1
     *      score = max(scores[left], scores[right])
     *  3 right - left >= 2
     *      scoreLeft = scores[left] + min(score(left + 1, right - 1), score(left + 2, right))
     *      scoreRight = scores[right] + min(score(left + 1, right - 1), score(left, right - 2))
     *      score = max(scoreLeft, scoreRight)
     */
    public static void main(String[] args) {
        int[] scores = new int[] {5, 200, 2, 3, 5};
        new CanWin().result(scores);
        new CanWin().result2(scores);
        new CanWin().result3(scores);
        new CanWin().result4(scores);
    }


    private void result3(int[] scores) {
        boolean canWin = dp(scores);
        System.out.println("resultScore of Player1 = " + canWin);
    }

    private void result4(int[] scores) {
        boolean canWin = dp2(scores);
        System.out.println("resultScore of Player1 = " + canWin);
    }

    private void result2(int[] scores) {
        int player1Score = maxScore2(scores, 0, scores.length - 1);
        System.out.println("resultScore of Player1 = " + player1Score);
    }

    private void result(int[] scores) {
        int sum = 0;
        for (int i: scores) {
            sum += i;
        }

        int player1Score = maxScore(scores, 0, scores.length - 1);
        int player2Score = sum - player1Score;
        boolean result = player1Score > player2Score;
        System.out.println("result = " + result);
    }

    private int maxScore(int[] scores, int left, int right) {
        if (left == right) {
            return scores[left];
        }
        int scoreLeft = 0;
        int scoreRight = 0;
        if (1 == right - left) {
            scoreLeft = scores[left];
            scoreRight = scores[right];
        }

        if (right - left >= 2) {
            //选左边能拿到的最大分数
            int minLeft = Math.min(maxScore(scores, left + 1, right - 1), maxScore(scores, left + 2, right));
            scoreLeft = scores[left] + minLeft;

            //选右边能拿到的最大分数
            int minRight = Math.min(maxScore(scores, left + 1, right - 1), maxScore(scores, left, right - 2));
            scoreRight = scores[right] + minRight;
        }
        return Math.max(scoreLeft, scoreRight);
    }

    private int maxScore2(int[] scores, int left, int right) {
        if (left == right) {
            return scores[left];
        }

        int sLeft = scores[left] - maxScore2(scores, left + 1, right);
        int rRight = scores[right] - maxScore2(scores, left, right - 1);

        return Math.max(sLeft, rRight);
    }

    //maxScore(scores, left + 1, right) --> [i+1][j] [i][j-1]
    private boolean dp(int[] scores) {
        int N = scores.length;
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            dp[i][i] = scores[i];
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                int sLeft = scores[i] - dp[i + 1][j];
                int sRight = scores[j] - dp[i][j - 1];
                dp[i][j] = Math.max(sLeft, sRight);
            }
        }

        return dp[0][N - 1] >= 0;
    }

    private boolean dp2(int[] scores) {
        int N = scores.length;
        int[] dp = new int[N];

        System.arraycopy(scores, 0, dp, 0, N);

        for (int i = N - 2; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                int sLeft = scores[i] - dp[j];
                int sRight = scores[j] - dp[j - 1];
                dp[j] = Math.max(sLeft, sRight);
            }
        }

        return dp[N - 1] >= 0;
    }

//    private double getSuite(double x, int i, int j) {
//        if (1 == i) {
//            return Math.min(x, 1);
//        }
//        if (2 == i) {
//            return x - 3;
//        }
//
//        double superLeft = getSuite(x, i - 1, j - 1);
//        double superRight = getSuite(x, i -1, j);
//        double max = Math.max(superLeft, superRight);
//        double min = Math.min(superLeft, superRight);
//
//
//        return (x - superLeft)
//    }
}
