package io.been;

public class Leetcode674 {
    public int findLengthOfLCIS(int[] nums) {
        int start = 0;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}
