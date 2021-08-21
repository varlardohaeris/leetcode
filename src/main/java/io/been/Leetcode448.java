package io.been;

import java.util.ArrayList;
import java.util.List;

public class Leetcode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        int index = 0;
        while (index < len) {
            if (nums[index] == index + 1) {
                index++;
            } else {
                int targetIndex = nums[index] - 1;
                if (nums[targetIndex] == nums[index]) {
                    index++;
                    continue;
                }
                int temp = nums[targetIndex];
                nums[targetIndex] = nums[index];
                nums[index] = temp;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] != (i + 1)) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
