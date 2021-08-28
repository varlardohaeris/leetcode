package io.been.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode417 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0) return res;

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pa = new boolean[n][m];
        boolean[][] at = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            dfs(i, 0, heights, pa, Integer.MIN_VALUE);
            dfs(i, m - 1, heights, at, Integer.MIN_VALUE);
        }

        for (int j = 0; j < m; j++) {
            dfs(n - 1, j, heights, at, Integer.MIN_VALUE);
            dfs(0, j, heights, pa, Integer.MIN_VALUE);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pa[i][j] && at[i][j]) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(i);
                    cur.add(j);
                    res.add(cur);
                }
            }
        }
        return res;
    }

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void dfs(int x, int y, int[][] matrix, boolean[][] oc, int height) {
        int n = matrix.length;
        int m = matrix[0].length;

        if (x < 0 || y < 0 || x >= n || y >= m || oc[x][y] || matrix[x][y] < height) return;
        oc[x][y] = true;
        for (int[] d : dirs) {
            dfs(x + d[0], y + d[1], matrix, oc, matrix[x][y]);
        }
    }
}
