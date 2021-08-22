package io.been;

public class Leetcode287 {
    public int findDuplicate(int[] nums) {
        if (nums.length < 1) return -1;
        int s = nums[0];
        int f = nums[s];
        while (s != f) {
            s = nums[s];
            f = nums[nums[f]];
        }
        f = 0;
        while (s != f) {
            s = nums[s];
            f = nums[f];
        }
        return s;
    }
}
