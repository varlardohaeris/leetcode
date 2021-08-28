package io.been.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode257 {
    private List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode node, String cur) {
        if (node == null) return;
        cur = cur + node.val + "->";
        if (node.left == null && node.right == null) {
            cur = cur.substring(0, cur.length() - 2);
            res.add(new String(cur));
        }
        dfs(node.left, cur);
        dfs(node.right, cur);
    }
}
