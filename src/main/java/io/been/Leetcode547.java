package io.been;

public class Leetcode547 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, visited, isConnected);
                ans++;
            }
        }
        return ans;
    }

    private void dfs(int i, int n, boolean[] visited, int[][] isConnected) {
        for (int j = 0; j < n; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(j, n, visited, isConnected);
            }
        }
    }

}
