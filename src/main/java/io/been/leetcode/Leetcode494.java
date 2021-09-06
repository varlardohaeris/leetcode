package io.been.leetcode;

import java.util.Arrays;

public class Leetcode494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum < target || target < -sum) return 0;
        int n = nums.length;
        int[][] dp = new int[n][2 * sum + 1];
        dp[0][nums[0] + sum]++;
        dp[0][-nums[0] + sum]++;
        for (int i = 1; i < n; i++) {
            for (int j = -sum; j <= sum; j++) {
                if (j + sum - nums[i] >= 0) {
                    dp[i][j + sum] += dp[i - 1][j - nums[i] + sum];
                }
                if (j + sum + nums[i] <= 2 *sum) {
                    dp[i][j + sum] += dp[i - 1][j + nums[i] + sum];
                }
            }
        }
        return dp[n - 1][target + sum];
    }
}
