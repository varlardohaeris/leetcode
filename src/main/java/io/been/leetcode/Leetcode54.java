package io.been.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = 0;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up
        int d = 0;
        for (int i = 0; i < m * n; i++) {
            res.add(matrix[x][y]);
            matrix[x][y] = Integer.MAX_VALUE;
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];
            if (dx < 0 || dx >= m || dy < 0 || dy >= n || matrix[dx][dy] == Integer.MAX_VALUE) {
                d = (d + 1) % 4;
                dx = x + dir[d][0];
                dy = y + dir[d][1];
            }
            x = dx;
            y = dy;
        }
        return res;
    }
}
