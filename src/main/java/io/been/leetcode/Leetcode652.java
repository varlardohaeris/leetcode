package io.been.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode652 {
    private List<TreeNode> res = new ArrayList<>();
    private Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        travsersal(root);
        return res;
    }

    private String travsersal(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = travsersal(root.left);
        String right = travsersal(root.right);
        String tree = left + "," + right + "," + root.val;
        int freq = map.getOrDefault(tree, 0);
        if (freq == 1) {
            res.add(root);
        }
        map.put(tree, freq + 1);
        return tree;
    }
}
