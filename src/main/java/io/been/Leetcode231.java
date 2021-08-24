package io.been;

public class Leetcode231 {
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        while (n > 0 && count < 2) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count == 1;
    }
}
