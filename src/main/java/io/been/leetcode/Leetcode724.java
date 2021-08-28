package io.been.leetcode;

import java.util.Arrays;

public class Leetcode724 {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            if (cur == sum) {
                return i;
            }
            sum -= nums[i];
        }
        return -1;
    }
}
