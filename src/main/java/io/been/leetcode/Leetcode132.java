package io.been.leetcode;

import java.util.Arrays;

public class Leetcode132 {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] flag = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(flag[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                flag[i][j] = (s.charAt(i) == s.charAt(j) && flag[i + 1][j - 1]);
            }
        }
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (flag[0][i]) {
                ans[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (flag[j + 1][i]) {
                        ans[i] = Math.min(ans[i], ans[j] + 1);
                    }
                }
            }
        }
        return ans[n - 1];
    }
}
