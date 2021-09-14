package io.been.leetcode;

/**
 * https://www.cnblogs.com/grandyang/p/4501934.html
 */

public class Leetcode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (left <= i && sum >= target) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int index = new Leetcode209().minSubArrayLen(7, nums);
        System.out.println(index);
    }
}
