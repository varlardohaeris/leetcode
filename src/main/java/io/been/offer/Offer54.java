package io.been.offer;

import io.been.leetcode.TreeNode;

public class Offer54 {
    private int res;
    private int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null || k == 0) return;
        dfs(node.right);
        if (--k == 0) {
            res = node.val;
        }
        dfs(node.left);
    }
}
