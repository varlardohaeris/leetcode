package io.been.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode51 {
    private List<List<String>> res = new ArrayList<>();
    private char[][] board;

    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        dfs(0);
        return res;
    }

    private void dfs(int col) {
        if (col == board.length) {
            res.add(transform());
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isValid(i, col)) {
                board[i][col] = 'Q';
                dfs(col + 1);
                board[i][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col) {
        for (int i = 0; i <= col; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == 'Q'
                        && (j == row || i + j == row + col || j - row == i - col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> transform() {
        List<String> res = new ArrayList<>();
        for (char[] chars : board) {
            res.add(String.valueOf(chars));
        }
        return res;
    }
}
