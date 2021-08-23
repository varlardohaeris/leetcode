package io.been;

import java.util.HashMap;
import java.util.Map;

public class Leetcode525 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                nums[i] = nums[i] == 0 ? -1 : nums[i];
            } else {
                if (nums[i] == 0) {
                    nums[i] = nums[i - 1] - 1;
                } else {
                    nums[i] += nums[i - 1];
                }
            }
            if (map.containsKey(nums[i])) {
                max = Math.max(max, i - map.get(nums[i]));
            } else {
                map.put(nums[i], i);
            }
        }
        return max;
    }
}
