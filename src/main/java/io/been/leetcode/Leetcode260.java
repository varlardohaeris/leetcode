package io.been.leetcode;

public class Leetcode260 {
    public int[] singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        int diff = 1;
        while ((xor & diff) == 0) {
            diff = diff << 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & diff) == 0) {
                a = a ^ nums[i];
            } else {
                b = b ^ nums[i];
            }
        }
        return new int[]{a, b};
    }

}
