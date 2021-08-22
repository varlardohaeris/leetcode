package io.been;

public class Leetcode230 {
    private int index = 0;

    public int kthSmallest(TreeNode root, int k) {
        return inorder(root, k);
    }

    public Integer inorder(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        Integer left = inorder(root.left, k);
        if (left != null) {
            return left;
        }
        index++;
        if (index == k) {
            return root.val;
        }
        Integer right = inorder(root.right, k);
        if (right != null) {
            return right;
        }
        return null;
    }
}
