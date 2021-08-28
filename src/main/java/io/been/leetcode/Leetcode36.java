package io.been.leetcode;


public class Leetcode36 {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            int[] map = new int[128];
            for (int i = 0; i < 9; i++) {
                char c = board[row][i];
                if (c != '.') {
                    if (map[c] > 0) {
                        return false;
                    } else {
                        map[c]++;
                    }
                }
            }
        }

        for (int col = 0; col < 9; col++) {
            int[] map = new int[128];
            for (int i = 0; i < 9; i++) {
                char c = board[i][col];
                if (c != '.') {
                    if (map[c] > 0) {
                        return false;
                    } else {
                        map[c]++;
                    }
                }
            }
        }

        for (int box = 0; box < 9; box++) {
            int[] map = new int[128];
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    char c = board[row + 3 * (box / 3)][col + 3 * (box % 3)];
                    if (c != '.') {
                        if (map[c] > 0) {
                            return false;
                        } else {
                            map[c]++;
                        }
                    }
                }
            }
        }

        return true;
    }
}
