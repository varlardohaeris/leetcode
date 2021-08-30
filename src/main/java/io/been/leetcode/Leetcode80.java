package io.been.leetcode;

public class Leetcode80 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        int index = 1;
        int len = 1;
        int last = nums[0];
        while (index < n) {
            int count = 1;
            while (index < n && nums[index] == last) {
                ++count;
                ++index;
            }
            if (count >= 2) nums[len++] = last;
            if (index < n) {
                last = nums[index++];
                nums[len++] = last;
            }
        }
        return len;
    }
}
