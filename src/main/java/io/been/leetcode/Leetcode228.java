package io.been.leetcode;

import java.util.List;
import java.util.Stack;

public class Leetcode228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new Stack<>();
        if (nums.length == 0) {
            return res;
        }
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 != nums[i - 1]) {
                if (i - 1 == start) {
                    res.add(nums[start] + "");
                } else {
                    res.add(nums[start] + "->" + nums[i - 1]);
                }
                start = i;
            }
        }
        if (start == nums.length - 1) {
            res.add(nums[start] + "");
        } else {
            res.add(nums[start] + "->" + nums[nums.length - 1]);
        }
        return res;
    }
}
