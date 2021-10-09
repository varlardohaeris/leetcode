package io.been.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode437 {
    private int res = 0;
    private int targetSum = 0;
    private Map<Integer, Integer> map;

    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        map = new HashMap<>();
        map.put(0, 1);
        backtrack(0, root);
        return res;
    }

    public void backtrack(int sum, TreeNode node) {
        if (node == null) return;
        sum += node.val;
        if (map.containsKey(sum - targetSum) && map.get(sum - targetSum) >= 1) {
            res += map.get(sum - targetSum);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        backtrack(sum, node.left);
        ;
        backtrack(sum, node.right);
        map.put(sum, map.get(sum) - 1);
    }
}
