package io.been;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1799 {
    private Map<Integer, Integer> cache = new HashMap<>();

    public int maxScore(int[] nums) {
        return dfs(nums, 1, 0);
    }

    int dfs(int[] nums, int round, int state) {
        if (round > nums.length / 2) return 0;
        if (cache.get(state) != null) {
            return cache.get(state);
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int picked = (1 << i) | (1 << j);
                if ((state & picked) == 0) {
                    ans = Math.max(ans, round * gcd(nums[i], nums[j])
                            + dfs(nums, round + 1, state | picked));
                }
            }
        }
        cache.put(state, ans);
        return ans;
    }

    private int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a == b) return a;
        if (a > b) {
            return gcd(a - b, b);
        }
        return gcd(a, b - a);
    }
}
