package io.been.leetcode;

/**
 * https://leetcode.com/problems/out-of-boundary-paths/discuss/102967/java-solution-dp-with-space-compression
 */

public class Leetcode576 {
    public int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) return 0;
        int mod = 1000000007;
        int[][] count = new int[m][n];
        count[i][j] = 1;
        int res = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] dir : dirs) {
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            res = (res + count[r][c]) % mod;
                        } else {
                            temp[nr][nc] = (temp[nr][nc] + count[r][c]) % mod;
                        }
                    }
                }
            }
            count = temp;
        }
        return res;
    }
}
