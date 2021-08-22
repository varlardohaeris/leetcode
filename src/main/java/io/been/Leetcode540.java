package io.been;

public class Leetcode540 {
    public int singleNonDuplicate(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
