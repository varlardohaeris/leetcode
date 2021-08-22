package io.been;

public class Leetcode222 {
    public int countNodes(TreeNode root) {
        int l = leftHeight(root);
        int r = rightHeight(root);
        return (l == r) ? (1 << l) - 1
                : 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int leftHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + leftHeight(root.left);
    }

    private int rightHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + rightHeight(root.right);
    }
}
