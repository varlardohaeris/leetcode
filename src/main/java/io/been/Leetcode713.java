package io.been;

public class Leetcode713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int curProduct = 1;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) {
                start = i + 1;
                curProduct = 1;
            } else {
                curProduct *= nums[i];
                while (curProduct >= k) {
                    curProduct /= nums[start];
                    start++;
                }
            }
            if (curProduct < k) {
                res += i - start + 1;
            }
        }
        return res;
    }
}
