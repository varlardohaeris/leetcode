package io.been.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode212 {

    private Set<String> res = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int m = board.length;
        if (m < 1) return new ArrayList<>(res);
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                findWords(board, visited, "", i, j, trie);
            }
        }
        return new ArrayList<>(res);
    }

    private void findWords(char[][] board, boolean[][] visited,
                           String str, int x, int y, Trie trie) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }

        if (visited[x][y]) return;
        String newStr = str + board[x][y];
        if (!trie.startsWith(newStr)) {
            return;
        }
        if (trie.search(newStr)) {
            res.add(newStr);
        }
        visited[x][y] = true;
        findWords(board, visited, newStr, x - 1, y, trie);
        findWords(board, visited, newStr, x + 1, y, trie);
        findWords(board, visited, newStr, x, y - 1, trie);
        findWords(board, visited, newStr, x, y + 1, trie);
        visited[x][y] = false;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String item = "";

        public TrieNode() {

        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = this.root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.item = word;
        }

        public boolean search(String word) {
            TrieNode node = this.root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return node.item.equals(word);
        }

        public boolean startsWith(String prefix) {
            TrieNode node = this.root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return true;
        }
    }
}

