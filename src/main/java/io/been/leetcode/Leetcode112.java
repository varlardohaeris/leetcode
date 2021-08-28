package io.been.leetcode;

public class Leetcode112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return visit(root, targetSum, 0);
    }

    private boolean visit(TreeNode node, int target, int curr) {
        if (node == null) return false;
        if (node.left == null && node.right == null) {
            return (curr + node.val == target);
        } else {
            return visit(node.left, target, curr + node.val) ||
                    visit(node.right, target, curr + node.val);
        }
    }
}
