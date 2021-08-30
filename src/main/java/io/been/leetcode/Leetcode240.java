package io.been.leetcode;

public class Leetcode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            int x = matrix[row][col];
            if (x == target) {
                return true;
            } else if (x < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
