package io.been.leetcode;

public class Leetcode98 {
    private TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }

    private boolean inorder(TreeNode node) {
        if (node == null) return true;
        if (!inorder(node.left)) return false;
        if (prev != null && node.val <= prev.val) return false;
        prev = node;
        return inorder(node.right);
    }
}
