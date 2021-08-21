package io.been;

import java.util.*;

public class Leetcode310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] neiTotal = new int[n];
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            neiTotal[edge[0]]++;
            neiTotal[edge[1]]++;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (neiTotal[i] == 1) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();
                list.add(cur);
                neiTotal[cur]--;
                List<Integer> curNei = map.get(cur);
                for (int j = 0; j < curNei.size(); j++) {
                    if (--neiTotal[curNei.get(j)] == 1) {
                        queue.add(curNei.get(j));
                    }
                }
                ans = list;
            }
        }
        return ans;
    }
}
