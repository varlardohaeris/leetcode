package io.been;

import java.util.Arrays;

public class Leetcode787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[dst][0] = 0;
        for (int K = 0; K < k + 1; K++) {
            for (int[] f : flights) {
                int s = f[0];
                int d = f[1];
                int cost = f[2];
                if (dp[d][K] == -1) {
                    continue;
                }
                if (dp[s][K + 1] == -1) {
                    dp[s][K + 1] = dp[d][K] + cost;
                }
                dp[s][K + 1] = Math.min(dp[s][K + 1], dp[d][K] + cost);
            }
        }
        int min = -1;
        for (int K = 0; K <= k + 1; K++) {
            if (dp[src][K] != -1) {
                min = min == -1 ? dp[src][K] : Math.min(min, dp[src][K]);
            }
        }
        return min;
    }
}
