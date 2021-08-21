package io.been;


public class Leetcode312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = j; i >= 0; i--) {
                dp[i][j] = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int left = i == 0 ? 1 : nums[i - 1];
                    int right = j == n - 1 ? 1 : nums[j + 1];
                    int leftSum = k == i ? 0 : dp[i][k - 1];
                    int rightSum = k == j ? 0 : dp[k + 1][j];
                    dp[i][j] = Math.max(dp[i][j], left * nums[k] * right + leftSum + rightSum);
                }
            }
        }
        return dp[0][n - 1];
    }
}
