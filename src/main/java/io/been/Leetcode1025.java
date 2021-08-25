package io.been;

public class Leetcode1025 {
    public boolean divisorGame(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int x = 1; x < i; x++) {
                if (i % x == 0) {
                    dp[i] = !dp[i - x];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[n];
    }
}
