package io.been.leetcode;

import java.util.Arrays;

public class Leetcode976 {
    public int largestPerimeter(int[] nums) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                ans = nums[i] + nums[i - 1] + nums[i - 2];
                break;
            }
        }
        return ans;
    }
}
