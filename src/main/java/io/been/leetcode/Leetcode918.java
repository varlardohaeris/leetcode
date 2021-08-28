package io.been.leetcode;

public class Leetcode918 {
    public int maxSubarraySumCircular(int[] nums) {
        int min = 0;
        int maxRes = Integer.MIN_VALUE;
        int max = 0;
        int minRes = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                nums[i] += nums[i - 1];
            }
            maxRes = Math.max(maxRes, nums[i] - min);
            min = Math.min(min, nums[i]);
            minRes = Math.min(minRes, nums[i] - max - nums[0]);
            max = Math.max(max, nums[i] - nums[0]);
        }
        return Math.max(maxRes, nums[nums.length - 1] - minRes);
    }
}
