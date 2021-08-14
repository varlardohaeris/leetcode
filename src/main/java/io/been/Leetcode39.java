package io.been;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode39 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(candidates, 0, target, track);
        return res;
    }

    private void backtrack(int[] candidates, int start,
                           int target, LinkedList<Integer> track) {
        if (target == 0) {
            res.add(new LinkedList<>(track));
            return;
        }
        if (target < 0 || start >= candidates.length) {
            return;
        }
        track.add(candidates[start]);
        backtrack(candidates, start, target - candidates[start], track);
        track.removeLast();
        backtrack(candidates, start + 1, target, track);
    }
}
