package io.been.leetcode;

public class Leetcode292 {
    public boolean canWinNim(int n) {
        if (n == 0) return false;
        return n % 4 != 0;
    }
}
