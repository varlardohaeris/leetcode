package io.been;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode18 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            for (int j = i + 1; j < n; j++) {
                if (j > (i + 1) && nums[j - 1] == nums[j]) {
                    continue;
                }
                int l = j + 1;
                int r = n - 1;
                int sum = nums[i] + nums[j];
                while (l < r) {
                    int total = sum + nums[l] + nums[r];
                    if (total < target) {
                        l++;
                    } else if (total > target) {
                        r--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        res.add(list);
                        while ((l + 1) < nums.length && nums[l] == nums[l + 1]) l++;
                        l++;
                        while ((r - 1) >= 0 && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
