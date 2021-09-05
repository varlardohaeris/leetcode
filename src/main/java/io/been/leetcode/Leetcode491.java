package io.been.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        findSub(set, nums, new ArrayList<Integer>(), 0);
        return new ArrayList<>(set);
    }

    private void findSub(Set<List<Integer>> set, int[] nums, List<Integer> list, int index) {
        if (list.size() > 1) {
            set.add(new ArrayList<>(list));
        }
        for (int i = index; i < nums.length; i++) {
            if (list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
                list.add(nums[i]);
                findSub(set, nums, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

}
