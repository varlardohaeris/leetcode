package io.been.leetcode;

public class Leetcode617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 != null && root2 != null) {
            root1.val += root2.val;
            TreeNode left = mergeTrees(root1.left, root2.left);
            TreeNode right = mergeTrees(root1.right, root2.right);
            root1.left = left;
            root1.right = right;
        }
        if (root1 == null) {
            return root2;
        }
        return root1;
    }
}
