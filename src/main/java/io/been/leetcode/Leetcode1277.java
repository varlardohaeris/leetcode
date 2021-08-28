package io.been.leetcode;

public class Leetcode1277 {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += matrix[i][0];
        }
        for (int i = 0; i < m; i++) {
            count += matrix[0][i];
        }
        count -= matrix[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                int min = Math.min(matrix[i][j - 1],
                        Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]));
                matrix[i][j] += min;
                count += matrix[i][j];
            }
        }
        return count;
    }
}
