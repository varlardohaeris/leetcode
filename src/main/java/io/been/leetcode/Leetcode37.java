package io.been.leetcode;

public class Leetcode37 {
    private int[][] rows_, cols_, boxes_;

    public void solveSudoku(char[][] board) {
        this.rows_ = new int[9][10];
        this.cols_ = new int[9][10];
        this.boxes_ = new int[9][10];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int n = c - '0';
                    int bx = j / 3;
                    int by = i / 3;
                    rows_[i][n] = 1;
                    cols_[j][n] = 1;
                    boxes_[by * 3 + bx][n] = 1;
                }
            }

        fill(board, 0, 0);
    }


    private boolean fill(char[][] board, int x, int y) {
        if (y == 9)
            return true;

        int nx = (x + 1) % 9;
        int ny = (nx == 0) ? y + 1 : y;

        if (board[y][x] != '.') return fill(board, nx, ny);

        for (int i = 1; i <= 9; i++) {
            int bx = x / 3;
            int by = y / 3;
            int box_key = by * 3 + bx;
            if (rows_[y][i] != 1 && cols_[x][i] != 1 && boxes_[box_key][i] != 1) {
                rows_[y][i] = 1;
                cols_[x][i] = 1;
                boxes_[box_key][i] = 1;
                board[y][x] = Character.forDigit(i, 10);
                if (fill(board, nx, ny)) return true;
                board[y][x] = '.';
                boxes_[box_key][i] = 0;
                cols_[x][i] = 0;
                rows_[y][i] = 0;
            }
        }
        return false;
    }

}
