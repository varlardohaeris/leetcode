package io.been;

import java.util.Arrays;

public class Leetcode1798 {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int cur = 0;
        for (int coin : coins) {
            if (cur + 1 >= coin) {
                cur += coin;
            }
        }
        return cur + 1;
    }
}
