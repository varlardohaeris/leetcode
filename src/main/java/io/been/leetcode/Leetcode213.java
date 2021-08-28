package io.been.leetcode;

public class Leetcode213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(rob(nums, 0, n - 2),
                rob(nums, 1, n - 1));
    }

    private int rob(int[] nums, int start, int end) {
        int n = nums.length;
        int dp1 = 0;
        int dp2 = 0;
        int dp = 0;
        for (int i = end; i >= start; i--) {
            dp = Math.max(dp1, nums[i] + dp2);
            dp2 = dp1;
            dp1 = dp;
        }
        return dp;
    }
}
