package io.been.leetcode;

import java.util.Arrays;
import java.util.Random;

public class Leetcode384 {
    class Solution {
        private int[] nums;
        private int[] data;
        private Random r = new Random();

        public Solution(int[] nums) {
            this.nums = nums;
            data = Arrays.copyOfRange(nums, 0, nums.length);
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return nums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int t = r.nextInt(n);
                int tmp = data[i];
                data[i] = data[t];
                data[t] = tmp;
            }
            return data;
        }
    }
}
