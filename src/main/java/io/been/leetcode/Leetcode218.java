package io.been.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode218 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> buildingPoints = new ArrayList<>();
        for (int[] b : buildings) {
            buildingPoints.add(new int[]{b[0], -b[2]});
            buildingPoints.add(new int[]{b[1], b[2]});
        }
        Collections.sort(buildingPoints, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(0);
        int preMax = 0;
        for (int[] bp : buildingPoints) {
            if (bp[1] < 0) {
                pq.offer(-bp[1]);
            } else {
                pq.remove(bp[1]);
            }
            int curHeight = pq.peek();
            if (curHeight != preMax) {
                List<Integer> list = new ArrayList<>();
                list.add(bp[0]);
                list.add(curHeight);
                res.add(list);
                preMax = curHeight;
            }

        }
        return res;
    }
}
