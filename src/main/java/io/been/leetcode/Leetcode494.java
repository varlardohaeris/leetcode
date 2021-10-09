package io.been.leetcode;


import java.util.HashMap;
import java.util.Map;

// https://www.cnblogs.com/grandyang/p/6395843.html

public class Leetcode494 {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer>[] dp = new HashMap[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = new HashMap<>();
        }
        dp[0].put(0, 1);
        for (int i = 0; i < n; i++) {
            for (Map.Entry<Integer, Integer> entry : dp[i].entrySet()) {
                int sum = entry.getKey();
                int cnt = entry.getValue();
                dp[i + 1].put(sum + nums[i], dp[i + 1].getOrDefault(sum + nums[i], 0) + cnt);
                dp[i + 1].put(sum - nums[i], dp[i + 1].getOrDefault(sum - nums[i], 0) + cnt);
            }
        }
        return dp[n].getOrDefault(target, 0);
    }
}
