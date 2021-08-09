package io.been;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (cache.containsKey(j)) {
                res[0] = i;
                res[1] = cache.get(target - nums[i]);
            } else {
                cache.put(nums[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] res = new TwoSum().twoSum(nums, 9);
        System.out.println(Arrays.toString(res));
    }
}
