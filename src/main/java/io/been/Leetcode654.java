package io.been;

public class Leetcode654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int idx = -1;
        int max = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            if (max < nums[i]) {
                idx = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = build(nums, low, idx - 1);
        root.right = build(nums, idx + 1, high);
        return root;
    }
}
