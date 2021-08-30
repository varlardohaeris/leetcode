package io.been.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode934 {
    private int[][] grid;

    public int shortestBridge(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        this.grid = grid;
        int n = grid.length;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (!found) {
                        solve(i, j);
                        found = true;
                    } else {
                        queue.add(new int[]{i, j});
                    }
                }
            }
        }
        int res = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                for (int[] dir : dirs) {
                    int x = node[0] + dir[0];
                    int y = node[1] + dir[1];
                    if (x < 0 || y < 0 || x >= n || y >= n || grid[x][y] == 1) continue;
                    if (grid[x][y] == 2) {
                        return res;
                    }
                    grid[x][y] = 1;
                    queue.offer(new int[]{x, y});
                }
            }
            res++;
        }
        return res - 1;
    }

    private void solve(int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid.length
                || grid[i][j] == 2 || grid[i][j] == 0) return;
        grid[i][j] = 2;
        solve(i - 1, j);
        solve(i + 1, j);
        solve(i, j - 1);
        solve(i, j + 1);
    }
}
