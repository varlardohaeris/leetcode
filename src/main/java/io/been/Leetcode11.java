package io.been;

public class Leetcode11 {
    public int maxArea(int[] height) {
        int ans = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int h = Math.min(height[l], height[r]);
            ans = Math.max(ans, h * (r - l));
            if (height[l] < height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }
}
