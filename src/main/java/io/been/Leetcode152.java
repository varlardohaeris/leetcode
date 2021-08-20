package io.been;

public class Leetcode152 {
    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            int curMax = Math.max(num, Math.max(num * max, num * min));
            int curMin = Math.min(num, Math.min(num * max, num * min));
            max = curMax;
            min = curMin;
            res = Math.max(max, res);
        }
        return res;
    }
}
