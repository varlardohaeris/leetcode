package io.been;

public class Leetcode785 {
    private int[][] graph;
    private int[] set;

    public boolean isBipartite(int[][] graph) {
        this.graph = graph;
        this.set = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (set[i] != 0) {
                continue;
            }
            if (!dfs(i, 1) && !dfs(i, -1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int flag) {
        if (set[node] != 0) {
            return flag == set[node];
        }
        set[node] = flag;
        for (int i : graph[node]) {
            if (!dfs(i, -flag)) {
                set[node] = 0;
                return false;
            }
        }
        return true;
    }
}
