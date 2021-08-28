package io.been.leetcode;

public class Leetcode543 {
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        lp(root);
        return ans;
    }

    private int lp(TreeNode root) {
        if (root == null) return -1;
        int l = lp(root.left) + 1;
        int r = lp(root.right) + 1;
        ans = Math.max(ans, l + r);
        return Math.max(l, r);
    }
}
