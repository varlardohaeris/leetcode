package io.been.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1263 {
    private final int[] deltaX = {0, 0, 1, -1};
    private final int[] deltaY = {-1, 1, 0, 0};

    public int minPushBox(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[grid.length][grid[0].length][4];
        int[] target = new int[2];
        int[] player = new int[2];
        int[] box = new int[2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'T') {
                    target[0] = i;
                    target[1] = j;
                    grid[i][j] = '.';
                }
                if (grid[i][j] == 'S') {
                    player[0] = i;
                    player[1] = j;
                    grid[i][j] = '.';
                }
                if (grid[i][j] == 'B') {
                    box[0] = i;
                    box[1] = j;
                    grid[i][j] = '.';
                }
            }
        }
        queue.offer(new int[]{
                box[0], box[1], player[0], player[1]
        });
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] cur = queue.poll();
                if (cur[0] == target[0] && cur[1] == target[1]) {
                    return res;
                }
                for (int index = 0; index < 4; index++) {
                    int nextX = cur[0] + deltaX[index];
                    int nextY = cur[1] + deltaY[index];
                    int playerX = cur[0] - deltaX[index];
                    int playerY = cur[1] - deltaY[index];
                    if (inArea(grid, nextX, nextY)
                            && inArea(grid, playerX, playerY)
                            && !visited[nextX][nextY][index]
                            && grid[nextX][nextY] == '.'
                            && grid[playerX][playerY] == '.'
                            && canPush(grid, playerX, playerY, cur[2], cur[3], cur[0], cur[1])) {
                        queue.offer(new int[]{nextX, nextY, playerX, playerY});
                        visited[nextX][nextY][index] = true;
                    }
                }
            }
            res++;
        }
        return -1;
    }


    private boolean canPush(char[][] grid,
                            int targetX,
                            int targetY,
                            int x,
                            int y,
                            int boxX,
                            int boxY) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == targetX && cur[1] == targetY) {
                return true;
            }
            for (int index = 0; index < 4; index++) {
                int nextX = cur[0] + deltaX[index];
                int nextY = cur[1] + deltaY[index];
                if (inArea(grid, nextX, nextY)
                        && !visited[nextX][nextY]
                        && grid[nextX][nextY] == '.'
                        && (nextX != boxX || nextY != boxY)) {
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
        return false;
    }

    private boolean inArea(char[][] grid, int nextX, int nextY) {
        if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) {
            return false;
        }
        return true;
    }

}
