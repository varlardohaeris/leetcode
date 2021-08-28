package io.been.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode993 {
    private Map<Integer, Integer> depths = new HashMap<>();
    private Map<Integer, Integer> parents = new HashMap<>();

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, 0);
        if (depths.get(x).equals(depths.get(y))
                && !parents.get(x).equals(parents.get(y))) {
            return true;
        }
        return false;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        depths.put(root.val, depth);
        if (root.left != null) {
            parents.put(root.left.val, root.val);
            dfs(root.left, depth + 1);
        }
        if (root.right != null) {
            parents.put(root.right.val, root.val);
            dfs(root.right, depth + 1);
        }
    }
}
