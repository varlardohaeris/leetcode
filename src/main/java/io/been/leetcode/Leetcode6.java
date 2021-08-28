package io.been.leetcode;


public class Leetcode6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }
        int row = 0;
        int step = 1;
        for (char c : s.toCharArray()) {
            rows[row].append(c);
            if (row == (numRows - 1)) {
                step = -1;
            } else if (row == 0) {
                step = 1;
            }
            row += step;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder temp : rows) {
            res.append(temp);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        new Leetcode6().convert("ABCDE", 5);
    }
}
