package io.been;

import java.util.Arrays;

public class Leetcode16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                }
                int d = Math.abs(sum - target);
                if (d < diff) {
                    diff = d;
                    res = sum;
                }
                if (sum > target) k--;
                else {
                    j++;
                }
            }
        }
        return res;
    }
}
