package io.been.leetcode;

public class Leetcode837 {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0) return 1;
        double[] dp = new double[maxPts + k + 1];
        double sum = 0;
        for (int i = k; i <= Math.min(n, k - 1 + maxPts); i++) {
            dp[i] = 1;
            sum += dp[i];
        }
        dp[k - 1] = sum / maxPts;
        for (int i = k - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + 1 + maxPts] - dp[i + 1]) / maxPts;
        }
        return dp[0];
    }
}
