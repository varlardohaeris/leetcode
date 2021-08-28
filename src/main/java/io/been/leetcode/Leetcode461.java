package io.been.leetcode;

public class Leetcode461 {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        return bitCount(z);
    }

    private int bitCount(int i) {
        int count = 0;
        while (i > 0) {
            if (i % 2 == 1) {
                count++;
            }
            i >>= 1;
        }
        return count;
    }
}
