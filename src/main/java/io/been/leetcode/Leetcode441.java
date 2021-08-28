package io.been.leetcode;

public class Leetcode441 {
    public int arrageCoins(int n) {
        for (int i = 1; i <= n; i++) {
            n = n - i;
            if (n <= i) {
                return i;
            }
        }
        return 0;
    }
}
