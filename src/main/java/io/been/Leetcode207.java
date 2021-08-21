package io.been;

import java.util.ArrayList;
import java.util.List;

public class Leetcode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequsite = prerequisites[i][1];
            graph.get(course).add(prerequsite);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, visited)) return false;
        }
        return true;
    }

    private boolean dfs(int cur, List<List<Integer>> graph, int[] visited) {
        if (visited[cur] == 1) return true;
        if (visited[cur] == 2) return false;
        visited[cur] = 1;
        for (int next : graph.get(cur)) {
            if (dfs(next, graph, visited)) return true;
        }
        visited[cur] = 2;
        return false;
    }
}
