package io.been.leetcode;

public class Leetcode110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(depth(root.left) - depth(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    public int depth(TreeNode n) {
        if (n == null) return 0;
        return Math.max(depth(n.left), depth(n.right)) + 1;
    }
}
