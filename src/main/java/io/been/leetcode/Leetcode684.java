package io.been.leetcode;

import java.util.Arrays;

public class Leetcode684 {
    private class UF {
        public int n;
        public int[] parent;
        public int[] rank;

        public UF(int n) {
            this.n = n;
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
            rank = new int[n + 1];
            Arrays.fill(rank, -1);
        }

        public void union(int x, int y) {
            x = find(x);
            y = find(y);
            if (rank[x] == rank[y]) {
                parent[x] = y;
                ++rank[y];
            } else if (rank[x] < rank[y]) {
                parent[x] = y;
            } else {
                parent[y] = x;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UF uf = new UF(n);
        for (int[] edge : edges) {
            if (uf.find(edge[0]) == uf.find(edge[1])) return edge;
            uf.union(edge[0], edge[1]);
        }
        return new int[2];
    }
}
