package io.been;

import java.util.ArrayList;
import java.util.List;

public class Leetcode886 {
    private List<Integer>[] graph;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
        }
        int[] colors = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (colors[i] != 0) {
                continue;
            }
            if (dfs(i, 1, colors)) {
                continue;
            }
            if (!dfs(i, -1, colors)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int cur, int color, int[] colors) {
        if (colors[cur] != 0) {
            return color == colors[cur];
        }
        colors[cur] = color;
        for (Integer child : graph[cur]) {
            if (!dfs(child, -color, colors)) {
                colors[cur] = 0;
                return false;
            }
        }
        return true;
    }


}
