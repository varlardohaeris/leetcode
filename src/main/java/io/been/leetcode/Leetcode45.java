package io.been.leetcode;

public class Leetcode45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int farthest = 0;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(nums[i] + i, farthest);
            if (end == i) {
                ans++;
                end = farthest;
            }
        }
        return ans;
    }
}
