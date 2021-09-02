package io.been.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode40 {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        combine(new ArrayList<>(), 0, target);
        return res;
    }

    private void combine(List<Integer> cur, int index, int target) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(cur));
        } else {
            for (int i = index; i < candidates.length; i++) {
                cur.add(candidates[i]);
                combine(cur, i + 1, target - candidates[i]);
                cur.remove(cur.size() - 1);
                while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                    i++;
                }
            }
        }
    }
}
