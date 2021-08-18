package io.been;

public class Leetcode75 {
    private int[] nums;

    public void sortColors(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                swap(i, l);
                l++;
            } else if (nums[i] == 2 && i < r) {
                swap(i, r);
                i--;
                r--;
            }
        }
    }

    private void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
