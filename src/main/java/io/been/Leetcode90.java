package io.been;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode90 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, track);
        return res;
    }

    private void backtrack(int[] nums, int idx, LinkedList<Integer> track) {
        res.add(new LinkedList<>(track));
        for (int i = idx; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i + 1, track);
            track.removeLast();
            while ((i + 1) < nums.length && nums[i] == nums[i + 1]) i++;
        }
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 2};
        List<List<Integer>> res = new Leetcode90().subsetsWithDup(data);
        System.out.println(res.size());
    }
}
