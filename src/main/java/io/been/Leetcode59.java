package io.been;

public class Leetcode59 {
    public int[][] generateMatrix(int n) {
        int count = 1;
        int layer = 0;
        int[][] grid = new int[n][n];
        while (layer < n / 2) {
            for (int i = layer; i < n - 1 - layer; i++) {
                grid[layer][i] = count++;
            }
            for (int i = layer; i < n - 1 - layer; i++) {
                grid[i][n - 1 - layer] = count++;
            }
            for (int i = n - 1 - layer; i > layer; i--) {
                grid[n - 1 - layer][i] = count++;
            }
            for (int i = n - 1 - layer; i > layer; i--) {
                grid[i][layer] = count++;
            }
            layer++;
        }
        if (n % 2 == 1) grid[n / 2][n / 2] = count++;
        return grid;
    }
}
