package io.been;

public class Leetcode124 {
    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return ans;
    }

    private int maxSum(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            ans = Math.max(ans, node.val);
            return node.val;
        } else {
            int left = maxSum(node.left);
            int right = maxSum(node.right);
            int sum = Math.max(left, right) + node.val;
            sum = Math.max(sum, node.val);
            ans = Math.max(ans, sum);
            ans = Math.max(ans, left + right + node.val);
            return sum;
        }
    }
}
