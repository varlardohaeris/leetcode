package io.been.leetcode;

public class Leetcode79 {
    private int h;
    private int w;

    public boolean exist(char[][] board, String word) {
        h = board.length;
        w = board[0].length;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (search(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int index, int x, int y) {
        if (x < 0 || x == w || y < 0 || y == h
                || word.charAt(index) != board[y][x]) {
            return false;
        }
        if (index == word.length() - 1) return true;
        char ch = board[y][x];
        board[y][x] = 0;
        boolean found = search(board, word, index + 1, x + 1, y)
                || search(board, word, index + 1, x - 1, y)
                || search(board, word, index + 1, x, y + 1)
                || search(board, word, index + 1, x, y - 1);
        board[y][x] = ch;
        return found;
    }
}
