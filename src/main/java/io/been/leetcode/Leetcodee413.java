package io.been.leetcode;

import java.util.Arrays;

public class Leetcodee413 {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return Arrays.stream(dp).sum();
    }
}
