package io.been.leetcode;

public class Leetcode123 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int[][] global = new int[n][3];
        int[][] local = new int[n][3];
        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= 2; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(diff, 0), local[i - 1][j] + diff);
                global[i][j] = Math.max(local[i][j], global[i - 1][j]);
            }
        }
        return global[n - 1][2];
    }
}
