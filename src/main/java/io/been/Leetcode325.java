package io.been;

import java.util.HashMap;
import java.util.Map;

public class Leetcode325 {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> sumIndex = new HashMap<>();
        int res = 0;
        int curSum = 0;
        sumIndex.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (sumIndex.containsKey(curSum - k)) {
                res = Math.max(res, i - sumIndex.get(curSum - k));
            }
            if (!sumIndex.containsKey(curSum)) {
                sumIndex.put(curSum, i);
            }
        }
        return res;
    }
}
