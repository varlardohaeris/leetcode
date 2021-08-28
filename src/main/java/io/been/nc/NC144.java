package io.been.nc;

public class NC144 {
    public long subsequence(int n, int[] array) {
        if (n == 1) return Math.max(array[0], 0);
        long[] dp = new long[n + 1];
        dp[0] = Math.max(0, array[0]);
        dp[1] = Math.max(dp[0], array[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + array[i]);
        }
        return dp[n - 1];
    }
}
