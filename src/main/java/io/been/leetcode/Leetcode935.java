package io.been.leetcode;

/**
 * https://www.cnblogs.com/grandyang/p/12393715.html
 */
public class Leetcode935 {
    private final int M = 1000000000 + 7;

    public int knightDialer(int n) {
        int res = 0;
        int[][] dp = new int[n][10];
        int[][] path = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {},
                {1, 7, 0}, {2, 6}, {1, 9}, {4, 2}};
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int idx : path[j]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][idx]) % M;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            res = (res + dp[n - 1][i]) % M;
        }
        return res;
    }
}
