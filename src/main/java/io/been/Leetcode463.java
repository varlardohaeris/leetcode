package io.been;

public class Leetcode463 {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                count += 4;
                for (int k = 0; k < dx.length; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < n
                            && ny >= 0 && ny < m
                            && grid[nx][ny] == 1) {
                        count -= 2;
                    }
                }
            }
        }
        return count;
    }
}
