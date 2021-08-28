package io.been.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] all = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            all[i] = intervals[i];
        }
        all[intervals.length] = newInterval;
        Arrays.sort(all, (o1, o2) -> o1[0] - o2[0]);

        int[] pre = all[0];
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < all.length; i++) {
            int[] now = all[i];
            if (pre[1] >= now[0]) {
                pre[1] = Math.max(pre[1], now[1]);
            } else {
                list.add(pre);
                pre = now;
            }
        }
        list.add(pre);
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
