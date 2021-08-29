package io.been.leetcode;

public class Leetcode543 {
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        lp(root);
        return ans;
    }

    private int lp(TreeNode root) {
        if (root == null) return 0;
        int l = lp(root.left);
        int r = lp(root.right);
        ans = Math.max(ans, l + r);
        return Math.max(l, r) + 1;
    }
}
