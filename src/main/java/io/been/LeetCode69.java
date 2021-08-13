package io.been;

public class LeetCode69 {
    public int mySqrt(int x) {
        long L = 0;
        long R = (long) x + 1;
        long ans = 0;
        while (L < R) {
            long mid = L + (R - L) / 2;
            if (guess(mid, x)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid;
            }
        }
        return (int) ans;
    }

    private boolean guess(long x, long y) {
        return x * x <= y;
    }

    public static void main(String[] args) {
        new LeetCode69().mySqrt(36);
    }
}
