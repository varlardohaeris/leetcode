package io.been.leetcode;

public class Leetcode97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if (n + m != s3.length()) {
            return false;
        }

        boolean[] pre = new boolean[m + 1];
        for (int i = n; i >= 0; i--) {
            boolean[] dp = new boolean[m + 1];
            for (int j = m; j >= 0; j--) {
                if (i == n && j == m) {
                    dp[j] = true;
                } else if (i == n) {
                    dp[j] = s2.substring(j).equals(s3.substring(i + j));
                } else if (j == m) {
                    dp[j] = s1.substring(i).equals(s3.substring(i + j));
                } else {
                    char a = s1.charAt(i);
                    char b = s2.charAt(j);
                    char c = s3.charAt(i + j);
                    if (a == b) {
                        if (a == c) {
                            dp[j] = pre[j] || dp[j + 1];
                        }
                    } else {
                        if (a == c) {
                            dp[j] = pre[j];
                        } else if (b == c) {
                            dp[j] = dp[j + 1];
                        }
                    }
                }
            }
            pre = dp;
        }
        return pre[0];
    }
}
