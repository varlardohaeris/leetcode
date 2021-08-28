package io.been.leetcode;

public class Leetcode190 {
    public int reverseBits(int n) {
        int res = 0;
        int mask = 1;
        int count = 32;
        while (count-- > 0) {
            res = res << 1;
            res += (mask & n);
            n >>= 1;
        }
        return res;
    }
}
