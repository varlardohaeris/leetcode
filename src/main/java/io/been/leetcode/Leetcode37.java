package io.been.leetcode;

public class Leetcode37 {
    private char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        backtrack(0, 0);
    }

    private boolean backtrack(int row, int col) {
        if (col == 9) {
            return backtrack(row + 1, 0);
        }
        if (row == 9) {
            return true;
        }

        if (board[row][col] != '.') {
            return backtrack(row, col + 1);
        }
        for (char c = '1'; c <= '9'; c++) {
            if (!isValid(row, col, c)) {
                continue;
            }
            board[row][col] = c;
            if (backtrack(row, col + 1)) {
                return true;
            }
            board[row][col] = '.';
        }
        return false;
    }

    private boolean isValid(int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) {
                return false;
            }
            if (board[i][col] == c) {
                return false;
            }
            if (board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
