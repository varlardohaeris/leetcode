package io.been.leetcode;

public class Leetcode875 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int pile : piles) {
                cnt += (pile + mid - 1) / mid;
            }
            if (cnt > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
