package io.been;

import java.util.ArrayList;
import java.util.List;

public class Leetcode113 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> cur = new ArrayList<>();
        dfs(root, targetSum, cur);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> cur) {
        if (root == null) return;
        cur.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<>(cur));
        } else {
            dfs(root.left, sum - root.val, cur);
            dfs(root.right, sum - root.val, cur);
        }
        cur.remove(cur.size() - 1);
    }
}
