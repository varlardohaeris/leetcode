package io.been.leetcode;

public class Leetcode329 {
    private int[][] matrix;
    private int[][] res;
    private boolean[][] visited;
    private int rows;
    private int cols;

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.res = new int[rows][cols];
        this.visited = new boolean[rows][cols];
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, dfs(i, j));
            }
        }
        return max;
    }

    private int dfs(int x, int y) {
        if (res[x][y] != 0) {
            return res[x][y];
        }
        visited[x][y] = true;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int len = 0;
        for (int i = 0; i < dx.length; i++) {
            int nextx = x + dx[i];
            int nexty = y + dy[i];
            if (nextx >= 0 && nextx < rows
                    && nexty >= 0 && nexty < cols
                    && !visited[nextx][nexty]
                    && matrix[nextx][nexty] > matrix[x][y]) {
                len = Math.max(len, dfs(nextx, nexty));
            }
        }
        visited[x][y] = false;
        res[x][y] = len + 1;
        return res[x][y];
    }
}
