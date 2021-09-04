package io.been.leetcode;

public class NumMatrix {
    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        if (matrix.length != 0 && matrix[0].length != 0) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            sum = new int[rows + 1][cols + 1];
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= cols; j++) {
                    sum[i][j] = matrix[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
    }
}
