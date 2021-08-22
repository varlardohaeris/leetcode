package io.been;

public class Leetcode733 {
    private int[][] image;
    private int rows;
    private int cols;
    private int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        this.image = image;
        this.rows = image.length;
        this.cols = image[0].length;
        dfs(sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public void dfs(int x, int y, int newColor, int oldColor) {
        if (image[x][y] != oldColor) {
            return;
        }
        image[x][y] = newColor;
        for (int[] dir : dirs) {
            int nx = dir[0] + x;
            int ny = dir[1] + y;
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                dfs(nx, ny, newColor, oldColor);
            }
        }
    }
}
