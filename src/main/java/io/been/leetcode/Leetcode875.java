package io.been.leetcode;

public class Leetcode875 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFinish(int[] piles, int speed, int h) {
        int time = 0;
        for (int n : piles) {
            time += speedOf(n, speed);
        }
        return time <= h;
    }

    private int speedOf(int n, int speed) {
        return (n / speed) + (((n % speed) > 0) ? 1 : 0);
    }

    private int getMax(int[] piles) {
        int res = piles[0];
        for (int i = 0; i < piles.length; i++) {
            res = Math.max(piles[i], res);
        }
        return res;
    }

}
