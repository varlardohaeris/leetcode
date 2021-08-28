package io.been.leetcode;

public class Leetcode997 {
    public int findJudge(int n, int[][] trust) {
        int[] out = new int[n + 1];
        int[] in = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            int from = trust[i][0];
            int to = trust[i][1];
            out[from]++;
            in[to]++;
        }

        for (int i = 1; i <= n; i++) {
            if (out[i] == 0 && in[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
