package io.been.leetcode;

public class Leetcode646 {
    public int findLongestChain(int[][] pairs) {
        int[] dp = new int[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            dp[i] = 1;
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = Math.max(dp[i], max);
        }
        return dp[pairs.length - 1];
    }
}
