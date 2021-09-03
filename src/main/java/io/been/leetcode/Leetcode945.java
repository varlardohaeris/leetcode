package io.been.leetcode;

import java.util.Arrays;

public class Leetcode945 {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            int pre = nums[i - 1];
            int cur = nums[i];
            if (pre >= cur) {
                res += pre - cur + 1;
                nums[i] = pre + 1;
            }
        }
        return res;
    }
}
