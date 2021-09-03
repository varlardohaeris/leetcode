package io.been.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode118 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return res;
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            int row = i + 1;
            for (int j = 0; j < row; j++) {
                if (j == 0 || j == row - 1) {
                    list.add(1);
                } else {
                    List<Integer> pre = res.get(i - 1);
                    int num = pre.get(j) + pre.get(j - 1);
                    list.add(num);
                }
            }
            res.add(list);
        }
        return res;
    }
}
