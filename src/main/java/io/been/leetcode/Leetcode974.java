package io.been.leetcode;

public class Leetcode974 {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int[] freq = new int[k];
        freq[0] = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                nums[i] += nums[i - 1];
            }
            int mod = nums[i] % k < 0 ? nums[i] % k + k : nums[i] % k;
            count += freq[mod];
            freq[mod]++;
        }
        return count;
    }
}
