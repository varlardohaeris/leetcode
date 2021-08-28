package io.been.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequsite = prerequisites[i][1];
            graph.get(course).add(prerequsite);
        }
        List<Integer> ans = new ArrayList<>();
        int index = numCourses;
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, visited, ans)) return new int[0];
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs(int cur, List<List<Integer>> graph, int[] visited, List<Integer> ans) {
        if (visited[cur] == 1) return true;
        if (visited[cur] == 2) return false;
        visited[cur] = 1;
        for (int next : graph.get(cur)) {
            if (dfs(next, graph, visited, ans)) return true;
        }
        ans.add(cur);
        visited[cur] = 2;
        return false;
    }
}
