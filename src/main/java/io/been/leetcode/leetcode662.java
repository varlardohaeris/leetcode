package io.been.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode662 {
    private int max;

    public int widthOfBinaryTree(TreeNode root) {
        this.max = 0;
        List<Integer> left = new ArrayList<>();
        dfs(root, 0, 0, left);
        return max;
    }

    private void dfs(TreeNode root, int depth, int x, List<Integer> left) {
        if (root == null) return;
        if (left.size() <= depth) {
            left.add(x);
        }
        int width = x - left.get(depth) + 1;
        max = Math.max(max, width);
        dfs(root.left, depth + 1, 2 * x, left);
        dfs(root.right, depth + 1, 2 * x + 1, left);
    }
}
