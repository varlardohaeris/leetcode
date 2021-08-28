package io.been.leetcode;

public class Leetcode174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1&& j == m - 1) {
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                    continue;
                }
                int min = Integer.MAX_VALUE;
                if (i + 1 < n) {
                    min = dp[i + 1][j] - dungeon[i][j];
                }
                if (j + 1 < m) {
                    min = Math.min(min, dp[i][j + 1] - dungeon[i][j]);
                }
                dp[i][j] = Math.max(1, min);
            }
        }
        return dp[0][0];
    }
}
