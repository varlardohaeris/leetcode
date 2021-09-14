package io.been.leetcode;

/**
 * https://www.cnblogs.com/grandyang/p/6201215.html
 */

public class Leetcode461 {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (z >> i) & 1;
        }
        return res;
    }
}
