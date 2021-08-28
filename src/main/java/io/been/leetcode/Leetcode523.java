package io.been.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderIndex = new HashMap<>();
        remainderIndex.put(0, -1);
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (k != 0) {
                curSum %= k;
            }
            if (remainderIndex.containsKey(curSum)) {
                if (i - remainderIndex.get(curSum) > 1) {
                    return true;
                }
            }
            if (!remainderIndex.containsKey(curSum)) {
                remainderIndex.put(curSum, i);
            }
        }
        return false;
    }
}
