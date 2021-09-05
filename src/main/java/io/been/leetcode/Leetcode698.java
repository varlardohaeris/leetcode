package io.been.leetcode;

import java.util.Arrays;

public class Leetcode698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int subSum = sum / k;
        Arrays.sort(nums);
        int beginIndex = nums.length - 1;
        if (nums[beginIndex] > subSum) return false;
        while (beginIndex >= 0 && nums[beginIndex] == subSum) {
            beginIndex--;
            k--;
        }
        return partition(new int[k], nums, beginIndex, subSum);
    }

    private boolean partition(int[] subsets, int[] nums, int index, int target) {
        if (index < 0) return true;
        int selected = nums[index];
        for (int i = 0; i < subsets.length; i++) {
            if (subsets[i] + selected <= target) {
                subsets[i] += selected;
                if (partition(subsets, nums, index - 1, target)) {
                    return true;
                }
                subsets[i] -= selected;
            }
        }
        return false;
    }
}
