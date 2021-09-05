package io.been.leetcode;

public class Leetcode687 {
    private int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        calculate(root);
        return res;
    }

    private int calculate(TreeNode root) {
        if (root == null) return 0;
        int leftCount = calculate(root.left);
        int rightCount = calculate(root.right);
        int left = 0;
        int right = 0;
        if (root.left != null && root.left.val == root.val) {
            left = leftCount + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right = rightCount + 1;
        }
        res = Math.max(res, left + right);
        return Math.max(left, right);
    }
}
