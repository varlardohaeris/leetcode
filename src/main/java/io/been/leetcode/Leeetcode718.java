package io.been.leetcode;

public class Leeetcode718 {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums1[i] != nums2[j]) {
                    continue;
                }
                dp[i][j] += 1;
                if (i > 0 && j > 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
