package io.been;

public class Leetcode1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) return true;
        int[] base = new int[2];
        base[0] = coordinates[1][0] - coordinates[0][0];
        base[1] = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            int[] vec = new int[2];
            vec[0] = coordinates[i][0] - coordinates[0][0];
            vec[1] = coordinates[i][1] - coordinates[0][1];
            int crossProduct = base[0] * vec[1] - base[1] * vec[0];
            if (crossProduct != 0) return false;
        }
        return true;
    }
}
