package io.been;

import java.util.ArrayList;
import java.util.List;

public class Leetcode797 {
    private List<List<Integer>> res = new ArrayList<>();
    private int[][] graph;
    private int n;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        this.n = graph.length;
        dfs(0, new ArrayList<>());
        return res;
    }

    private void dfs(int cur, List<Integer> path) {
        path.add(cur);
        if (cur == n - 1) {
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        for (int i : graph[cur]) {
            dfs(i, path);
        }
        path.remove(path.size() - 1);
    }
}
