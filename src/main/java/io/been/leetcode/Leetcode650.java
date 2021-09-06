package io.been.leetcode;

public class Leetcode650 {
    public int minSteps(int n) {
        int[] dp = new int[1001];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i / 2; j >= (int) Math.sqrt(i); j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                    break;
                }
            }
        }
        return dp[n];
    }
}
