package io.been.leetcode;

import java.util.Arrays;

public class Leetcode462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int move_count = 0;
        int mid = nums.length / 2;
        for (int num : nums) {
            move_count += Math.abs(num - nums[mid]);
        }
        return move_count;
    }
}
