package io.been.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode145 {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return res;
    }

    private void postorder(TreeNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            res.add(node.val);
        }
    }
}
