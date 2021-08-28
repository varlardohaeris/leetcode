package io.been.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1091 {
    private int[][] dis = {
            {1, -1},
            {1, 0},
            {1, 1},
            {0, -1},
            {0, 1},
            {-1, -1},
            {-1, 0},
            {-1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int len = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            len++;
            while (size-- > 0) {
                int[] cur = queue.poll();
                int cr = cur[0];
                int cc = cur[1];
                if (grid[cr][cc] == 1) {
                    continue;
                }
                if (cr == m - 1 && cc == n - 1) {
                    return len;
                }

                grid[cr][cc] = 1;
                for (int[] d : dis) {
                    int nr = cr + d[0];
                    int nc = cc + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }
                    queue.add(new int[]{nr, nc});
                }

            }
        }
        return -1;
    }
}
