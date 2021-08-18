package io.been;

public class Leetcode55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int far = nums[0];
        for (int i = 0; i < n; i++) {
            if (i > far) break;
            far = Math.max(far, i + nums[i]);
        }
        return far >= n - 1;
    }
}
