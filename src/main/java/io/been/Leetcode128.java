package io.been;

import java.util.HashSet;
import java.util.Set;

public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int len = 0;
                while (set.contains(cur)) {
                    cur++;
                    len++;
                }
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}
