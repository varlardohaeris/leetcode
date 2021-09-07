package io.been.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode694 {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                StringBuilder builder = new StringBuilder();
                dfs(grid, i, j, visited, i, j, builder);
                if (builder.length() > 0) {
                    set.add(builder.toString());
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int x, int y,
                     boolean[][] visited, int ox, int oy, StringBuilder builder) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return;
        if (visited[x][y] || grid[x][y] != 1) return;
        visited[x][y] = true;
        builder.append(x - ox).append(".").append(y - oy).append(".");
        for (int i = 0; i < dirs.length; i++) {
            int nextx = x + dirs[i][0];
            int nexty = y + dirs[i][1];
            dfs(grid, nextx, nexty, visited, ox, oy, builder);
        }
    }

}
