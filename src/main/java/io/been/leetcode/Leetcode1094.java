package io.been.leetcode;

public class Leetcode1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] d = new int[1001];
        for (int[] trip : trips) {
            d[trip[1]] -= trip[0];
            d[trip[2]] += trip[0];
        }
        for (int c : d) {
            if ((capacity += c) < 0) return false;
        }
        return true;
    }
}
