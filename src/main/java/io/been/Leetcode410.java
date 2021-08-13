package io.been;

public class Leetcode410 {
    private boolean guess(int mid, int[] nums, int m) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > mid) {
                --m;
                sum = nums[i];
                if (nums[i] > mid) {
                    return false;
                }
            } else {
                sum += nums[i];
            }
        }
        return m >= 1;
    }

    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int R = 1;
        for (int i = 0; i < n; i++) {
            R += nums[i];
        }
        int L = 0;
        int ans = 0;
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (guess(mid, nums, m)) {
                ans = mid;
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }
}
