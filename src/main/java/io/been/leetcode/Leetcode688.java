package io.been.leetcode;

import java.util.Arrays;

/**
 * https://www.cnblogs.com/grandyang/p/7639153.html
 */
public class Leetcode688 {
    public double knightProbability(int n, int k, int row, int column) {
        if (k == 0) return 1;
        double[][] dp = new double[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 1);
        }
        int[][] dirs = {
                {-1, -2}, {-2, -1},
                {-2, 1}, {-1, 2},
                {1, 2}, {2, 1},
                {2, -1}, {1, -2}
        };

        for (int m = 0; m < k; m++) {
            double[][] t = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < 0 || x >= n || y < 0 || y >= n) continue;
                        t[i][j] += dp[x][y];
                    }
                }
            }
            dp = t;
        }
        return dp[row][column] / Math.pow(8, k);
    }
}
