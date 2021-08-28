package io.been.nc;

public class Leetcode107 {
    public int solve(int[] a) {
        for (int i = a.length - 1; i >= 1; i--) {
            if (a[i] >= a[i - 1]) {
                return i;
            }
        }
        return 0;
    }
}
