package com.zfang.testapp;


/**
 * 井字游戏
 *   用字符串数组作为井字游戏的游戏板board,判断该游戏板有没有可能最终形成.
 *   游戏板是一个3x3数组，由字符" "，"X" 和"O"组成。字符" ”代表一个空位。
 * 两个玩家轮流将字符放入空位，一个玩家执X棋，另一个玩家执O棋,
 * “X”和“O” 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有3个相同(且非空)的字符填充任何行、列或对角线时，游戏结束，board生成.
 */
public class TictacToe {

    private static TictacToe app = new TictacToe();
    public static void main(String[] args) {
        app.result(new String[] {"XXX", "XXO", "O O"});
    }

    private void result(String[] board) {
        System.out.println("result = " + isValidBoard(board));
    }


    private boolean isValidBoard(String[] board) {
        /**
         * X先下
         * 1) X win X - O = 1
         * 2) O win X - O = 0
         * 3) 平 X - O = 1 || X - O = 0
         */
        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (char ch: board[i].toCharArray()) {
                if ('X' == ch) {
                    xCount++;
                }
                if ('O' == ch) {
                    oCount++;
                }
            }
        }

        int result = Math.abs(xCount - oCount);
        if (result > 1) {
            return false;
        }
        if (win(board, "XXX") && xCount - oCount != 1) {
            return false;
        }
        if (win(board, "OOO") && xCount - oCount != 0) {
            return false;
        }
        return true;
    }

    private boolean win(String[] board, String flag) {
        for (int i = 0; i < 3; i++) {
            //纵向3连
            String chStr = board[0].charAt(i) + board[1].charAt(i) + board[2].charAt(i) + "";
            if (flag.equals(chStr)) {
                return true;
            }
            //横向3连
            if (flag.equals(board[i])) {
                return true;
            }
        }

        //
        String chStr = "" + board[0].charAt(0) + board[1].charAt(1) + board[2].charAt(2);
        if (flag.equals(chStr)) {
            return true;
        }
        chStr = "" + board[0].charAt(2) + board[1].charAt(1) + board[2].charAt(0);
        if (flag.equals(chStr)) {
            return true;
        }

        return false;
    }
}
