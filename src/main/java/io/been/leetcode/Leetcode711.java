package io.been.leetcode;

import java.util.*;

public class Leetcode711 {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private Set<String> set = new HashSet<>();
    private boolean[][] visited;
    private int[][] grid;

    public int numDistinctIslands2(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        this.grid = grid;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<List<int[]>> allList = new ArrayList<>();
                    for (int t = 0; t < 6; t++) {
                        allList.add(new ArrayList<>());
                    }
                    dfs(i, j, i, j, allList);
                    boolean exist = false;
                    List<String> nset = new ArrayList<>();
                    for (List<int[]> list : allList) {
                        if (list.size() == 0) continue;
                        Collections.sort(list, new Comparator<int[]>() {
                            @Override
                            public int compare(int[] a, int[] b) {
                                return (a[0] != b[0]) ? (a[0] - b[0]) : (a[1] - b[1]);
                            }
                        });
                        String s = encode(list);
                        if (set.contains(s)) {
                            exist = true;
                        }
                        nset.add(s);
                        if (!exist) {
                            count++;
                            set.addAll(nset);
                        }
                    }
                }
            }
        }
        return count;
    }

    private String encode(List<int[]> list) {
        int ox = list.get(0)[0];
        int oy = list.get(0)[1];
        StringBuilder builder = new StringBuilder();
        builder.append("0,0;");
        for (int k = 1; k < list.size(); k++) {
            int dx = list.get(k)[0] - ox;
            int dy = list.get(k)[1] - oy;
            builder.append(dx).append(",").append(dy).append(";");
        }
        String s = builder.toString();
        return s;
    }

    private void dfs(int x, int y, int ox, int oy, List<List<int[]>> list) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        if (visited[x][y] || grid[x][y] == 0) return;
        visited[x][y] = true;
        addAll(list, x - ox, y - oy);
        for (int i = 0; i < dirs.length; i++) {
            int nextx = x + dirs[i][0];
            int nexty = y + dirs[i][0];
            dfs(nextx, nexty, ox, oy, list);
        }
    }

    private void addAll(List<List<int[]>> allList, int dx, int dy) {
        allList.get(0).add(new int[]{dx, dy});
        allList.get(1).add(new int[]{-dy, dx});
        allList.get(2).add(new int[]{-dx, -dy});
        allList.get(3).add(new int[]{dy, -dx});
        allList.get(4).add(new int[]{-dx, dy});
        allList.get(5).add(new int[]{dx, -dy});
    }

}
