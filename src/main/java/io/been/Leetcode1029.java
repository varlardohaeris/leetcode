package io.been;

import java.util.Arrays;

public class Leetcode1029 {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,
                (c1, c2) -> Integer.compare(c1[0] - c1[1], c2[0] - c2[1]));
        int total = 0;
        int n = costs.length;
        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                total += costs[i][0];
            } else {
                total += costs[i][1];
            }
        }
        return total;
    }
}
