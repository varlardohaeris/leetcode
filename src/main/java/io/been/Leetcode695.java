package io.been;

public class Leetcode695 {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int rows;
    private int cols;
    private int[][] grid;
    private boolean[][] visited;

    private boolean inArea(int i, int j) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        this.grid = grid;
        this.visited = new boolean[rows][cols];
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ans = Math.max(ans, dfs(i, j));
                }
            }
        }
        return ans;
    }

    private int dfs(int i, int j) {
        visited[i][j] = true;
        int area = 1;
        for (int[] dir : dirs) {
            int nextX = i + dir[0];
            int nextY = j + dir[1];
            if (inArea(nextX, nextY) && grid[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                area += dfs(nextX, nextY);
            }
        }
        return area;
    }
}
