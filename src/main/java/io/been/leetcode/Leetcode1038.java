package io.been.leetcode;

public class Leetcode1038 {
    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        traversal(root);
        return root;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.right);
        sum += root.val;
        root.val = sum;
        traversal(root.left);
    }
}
