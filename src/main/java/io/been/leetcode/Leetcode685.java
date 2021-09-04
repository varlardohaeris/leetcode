package io.been.leetcode;

public class Leetcode685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] can1 = new int[]{-1, -1};
        int[] can2 = new int[]{-1, -1};
        int[] root = new int[edges.length + 1];
        for (int[] edge : edges) {
            if (root[edge[1]] == 0) {
                root[edge[1]] = edge[0];
            } else {
                can2 = new int[]{edge[0], edge[1]};
                can1 = new int[]{root[edge[1]], edge[1]};
                edge[1] = 0;
            }
        }
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
        for (int[] edge : edges) {
            if (edge[1] == 0) {
                continue;
            }
            if (find(root, edge[0]) == edge[1]) {
                if (can1[0] == -1) {
                    return edge;
                } else {
                    return can1;
                }
            }
            root[edge[1]] = edge[0];
        }
        return can2;
    }

    private int find(int[] root, int p) {
        while (p != root[p]) {
            root[p] = root[root[p]];
            p = root[p];
        }
        return p;
    }
}
