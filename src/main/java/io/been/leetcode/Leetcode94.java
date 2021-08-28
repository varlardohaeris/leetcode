package io.been.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode94 {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return res;
    }

    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            res.add(node.val);
            inorder(node.right);
        }
    }
}
