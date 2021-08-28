package io.been.leetcode;

public class Leetcode538 {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        inorder(root);
        return root;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.right);
        sum += root.val;
        root.val = sum;
        inorder(root.left);
    }
}
