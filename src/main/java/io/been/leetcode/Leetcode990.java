package io.been.leetcode;

public class Leetcode990 {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (String s : equations) {
            if (s.charAt(1) == '!') {
                continue;
            }
            int l = s.charAt(0) - 'a';
            int r = s.charAt(3) - 'a';
            union(parent, l, r);
        }
        for (String s : equations) {
            if (s.charAt(1) == '=') {
                continue;
            }
            int l = s.charAt(0) - 'a';
            int r = s.charAt(3) - 'a';
            if (find(parent, l) == find(parent, r)) {
                return false;
            }
        }
        return true;
    }

    public void union(int[] parent, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);
        parent[pb] = pa;
    }

    private int find(int[] parent, int a) {
        while (parent[a] != a) {
            parent[a] = parent[parent[a]];
            a = parent[a];
        }
        return parent[a];
    }
}
