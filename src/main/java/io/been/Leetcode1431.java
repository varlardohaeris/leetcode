package io.been;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = Arrays.stream(candies).max().getAsInt();
        int n = candies.length;
        for (int i = 0; i < n; i++) {
            if (candies[i] + extraCandies >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
