package io.been;

import java.util.ArrayList;
import java.util.List;

public class Leetcode144 {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return res;
    }

    private void preorder(TreeNode node) {
        if (node != null) {
            res.add(node.val);
            preorder(node.left);
            preorder(node.right);
        }
    }
}
