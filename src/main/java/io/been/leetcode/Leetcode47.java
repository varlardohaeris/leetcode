package io.been.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, list, set);
        List<List<Integer>> res = new ArrayList<>();
        res.addAll(set);
        return res;
    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> list, Set<List<Integer>> set) {
        if (list.size() == nums.length) {
            set.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            backtrack(nums, visited, list, set);
            list.remove(list.size() - 1);
            visited[i] = false;
        }

    }

}
