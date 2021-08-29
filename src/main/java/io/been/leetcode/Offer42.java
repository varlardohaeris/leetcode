package io.been.leetcode;

public class Offer42 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);

        }
        return res;
    }
}
