package io.been.leetcode;

import java.util.Arrays;

public class Leetcode452 {
    public int findMinArrowShots(int[][] points) {
//        int arrow = 1;
//        Arrays.sort(points, (v1, v2) -> (Integer.compare(v1[1], v2[1])));
//        int right = points[0][1];
//        for (int i = 1; i < points.length; i++) {
//            if (points[i][0] <= right) {
//                continue;
//            } else {
//                arrow++;
//                right = points[i][1];
//            }
//        }
//        return arrow;

        if (points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int ans = 1;
        int end = points[0][1];
        for (int[] point : points) {
            int start = point[0];
            if (start > end) {
                ans++;
                end = point[1];
            }
        }
        return ans;
    }
}
