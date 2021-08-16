package io.been;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode973 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] * o1[0] + o1[1] * o1[1])
                        - (o2[0] * o2[0] + o2[1] * o2[1]);
            }
        });
        Collections.addAll(pq, points);
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
