package io.been.leetcode;
// https://www.cnblogs.com/grandyang/p/5294255.html
public class Leetcode338 {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i & (i - 1)] + 1;
        }
        return dp;
    }
}
