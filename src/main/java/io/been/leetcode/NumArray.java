package io.been.leetcode;

public class NumArray {
    private int[] tree;
    private int size;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            this.size = nums.length;
            tree = new int[size * 2];
            buildTree(nums);
        }
    }

    private void buildTree(int[] nums) {
        for (int i = size, j = 0; j < nums.length; i++, j++) {
            tree[i] = nums[j];
        }
        for (int i = size - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    public void update(int index, int val) {
        index += size;
        tree[index] = val;
        while (index > 0) {
            int left = index;
            int right = index;
            if (index % 2 == 0) {
                right = index + 1;
            } else {
                left = index - 1;
            }
            tree[index / 2] = tree[left] + tree[right];
            index /= 2;
        }
    }

    public int sumRange(int left, int right) {
        left += size;
        right += size;
        int sum = 0;
        while (left <= right) {
            if (left % 2 != 0) {
                sum += tree[left];
                left++;
            }
            if (right % 2 != 1) {
                sum += tree[right];
                right--;
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }

}
