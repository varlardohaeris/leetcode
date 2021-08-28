package io.been.leetcode;

import java.util.Arrays;

public class Leetcode198 {
    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob(nums, 0);
    }

    private int rob(int[] nums, int start) {
        if (start >= nums.length) return 0;
        if (memo[start] != -1) return memo[start];
        int res = Math.max(
                rob(nums, start + 1),
                rob(nums, start + 2) + nums[start]);
        memo[start] = res;
        return res;
    }
}
