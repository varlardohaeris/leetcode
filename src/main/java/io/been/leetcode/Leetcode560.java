package io.been.leetcode;

import java.util.HashMap;
import java.util.Map;
// https://www.bilibili.com/video/BV1WE411i76E?from=search&seid=2743421952263185254&spm_id_from=333.337.0.0
public class Leetcode560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
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
