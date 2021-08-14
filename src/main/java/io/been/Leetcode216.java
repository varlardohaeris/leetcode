package io.been;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode216 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(k, n, 1, track);
        return res;
    }

    private void backtrack(int k, int n, int start, LinkedList<Integer> track) {
        if (k == 0) {
            if (n == 0) {
                res.add(new LinkedList<>(track));
                return;
            }
        }
        for (int i = start; i <= 9; i++) {
            if (i > n) return;
            track.add(i);
            backtrack(k - 1, n - i, i + 1, track);
            track.removeLast();
        }
    }
}
