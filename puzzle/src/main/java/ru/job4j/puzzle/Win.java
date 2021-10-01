package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1 && (horizonLine(board, i) || verticalLine(board, i))) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public static boolean horizonLine(int[][] board, int index) {
        boolean rsl = true;
        for (int i = 0; i < board[index].length; i++) {
            if (board[index][i] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean verticalLine(int[][] board, int index) {
        boolean rsl = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][index] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
