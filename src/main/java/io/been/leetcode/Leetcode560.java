package io.been.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            int target = sum - k;
            int t = map.get(target) == null ? 0 : map.get(target);
            ans += t;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int ans = new Leetcode560().subarraySum(nums, 3);
        System.out.println(ans);
    }
}
