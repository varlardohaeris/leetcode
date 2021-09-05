package io.been.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode542 {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(i * cols + j);
                } else if (mat[i][j] == 1) {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[] dir = {0, 1, 0, -1, 0};
        while (!queue.isEmpty()) {
            int top = queue.poll();
            for (int k = 0; k < dir.length - 1; k++) {
                int x = top / cols + dir[k];
                int y = top % cols + dir[k + 1];
                if (x >= 0 && x < rows
                        && y >= 0 && y < cols
                        && mat[x][y] > 0
                        && mat[x][y] > mat[top / cols][top % cols] + 1) {
                    mat[x][y] = mat[top / cols][top % cols] + 1;
                    queue.offer(x * cols + y);
                }
            }
        }
        return mat;
    }
}
