package io.been.leetcode;

public class Leetcode31 {
    private int[] nums;

    public void nextPermutation(int[] nums) {
        this.nums = nums;

        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = n - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            swap(i, j);
        }
        reverse(i + 1, n - 1);
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int i, int j) {
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }
    }
}
