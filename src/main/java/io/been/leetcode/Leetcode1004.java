package io.been.leetcode;

public class Leetcode1004 {
    public static int longestOnes(int[] nums, int k) {
        int res = 0;
        int cnt = 0;
        int left = 0;
        int right = 0;
        int n = nums.length;
        while (right < n) {
            if (nums[right] == 0) {
                cnt += 1;
            }
            while (cnt > k) {
                if (nums[left] == 0) {
                    cnt -= 1;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int res = longestOnes(nums, 2);
        System.out.println(res);
    }
}
