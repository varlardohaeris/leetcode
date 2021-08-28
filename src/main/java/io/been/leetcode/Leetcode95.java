package io.been.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> l = generate(start, i - 1);
            List<TreeNode> r = generate(i + 1, end);
            for (TreeNode left : l) {
                for (TreeNode right : r) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
