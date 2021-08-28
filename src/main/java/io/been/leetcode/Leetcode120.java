package io.been.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<Integer> prev = triangle.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> dp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                dp.add(triangle.get(i).get(j)
                        + Math.min(prev.get(j), prev.get(j + 1)));
            }
            prev = new ArrayList<>(dp);
        }
        return prev.get(0);
    }
}
