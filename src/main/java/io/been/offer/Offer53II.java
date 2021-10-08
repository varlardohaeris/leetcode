package io.been.offer;

import java.util.Arrays;

public class Offer53II {
    public int missingNumber(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int total = 0;
        for (int i = 1; i <= nums.length; i++) {
            total += i;
        }
        return total - sum;
    }
}
