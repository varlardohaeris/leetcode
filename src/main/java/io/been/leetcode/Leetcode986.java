package io.been.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int an = firstList.length;
        int bn = secondList.length;
        List<int[]> res = new ArrayList<>();
        int aindex = 0;
        int bindex = 0;
        while (aindex < an && bindex < bn) {
            int start = Math.max(firstList[aindex][0], secondList[bindex][0]);
            int end = Math.min(firstList[aindex][1], secondList[bindex][1]);
            if (start <= end) {
                int[] pair = {start, end};
                res.add(pair);
            }
            if (end == firstList[aindex][1]) {
                aindex++;
            }
            if (end == secondList[bindex][1]) {
                bindex++;
            }
        }
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
