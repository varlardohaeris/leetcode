package io.been.leetcode;

public class Leetcode664 {
    public int strangePrinter(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i + j < len; i++) {
                dp[i][i + j] = j + 1;
                for (int k = i; k < i + j; k++) {
                    int total = dp[i][k] + dp[k + 1][i + j];
                    if (s.charAt(k) == s.charAt(i + j)) {
                        total--;
                    }
                    dp[i][j + i] = Math.min(dp[i][i + j], total);
                }
            }
        }
        return dp[0][len - 1];
    }
}
