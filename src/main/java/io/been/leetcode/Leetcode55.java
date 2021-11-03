package io.been.leetcode;

public class Leetcode55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = nums[0];
        for (int i = 0; i < n; i++) {
            if (i > farthest) break;
            farthest = Math.max(farthest, i + nums[i]);
        }
        return farthest >= n - 1;
    }
}
