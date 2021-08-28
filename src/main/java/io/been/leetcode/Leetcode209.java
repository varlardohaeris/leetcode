package io.been.leetcode;

public class Leetcode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int right = 0;
        int res = Integer.MAX_VALUE;
        while (true) {
            if (right == nums.length && left == nums.length) {
                break;
            }
            if (sum == target) {
                res = Math.min(right - left, res);
                if (right < nums.length) {
                    sum += nums[right];
                    right++;
                } else {
                    sum -= nums[left];
                    left++;
                }
            } else if (sum < target) {
                if (right == nums.length) {
                    break;
                }
                sum += nums[right];
                right++;
            } else {
                res = Math.min(right - left, res);
                sum -= nums[left];
                left++;
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
