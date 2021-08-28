package io.been.leetcode;

public class LeetCode42 {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        int left = 0;
        int right = n - 1;
        int l_max = height[left];
        int r_max = height[right];
        while (left <= right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);
            if (l_max < r_max) {
                ans += l_max - height[left];
                left++;
            } else {
                ans += r_max - height[right];
                right--;
            }
        }
        return ans;
    }
}
