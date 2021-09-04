package io.been.leetcode;

public class Leetcode498 {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }
        int rows = mat.length;
        int cols = mat[0].length;
        int[] res = new int[rows * cols];
        int scan = rows + cols - 1;
        int index = 0;
        for (int i = 0; i < scan; i++) {
            if (i % 2 == 0) {
                int x = i < rows ? i : rows - 1;
                int y = i < rows ? 0 : i - (rows - 1);
                while (x >= 0 && y < cols) {
                    res[index++] = mat[x--][y++];
                }
            } else {
                int x = i < cols ? 0 : i - (cols - 1);
                int y = i < cols ? i : cols - 1;
                while (x < rows && y >= 0) {
                    res[index++] = mat[x++][y--];
                }
            }
        }
        return res;
    }
}
