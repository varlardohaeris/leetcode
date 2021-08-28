package io.been.leetcode;

import java.util.Arrays;

public class Leetcode416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = sum; i >= 0; i--) {
                if (dp[i] > 0) dp[i + num] = 1;
            }
            if (dp[sum / 2] > 0) return true;
        }
        return false;
    }
}
