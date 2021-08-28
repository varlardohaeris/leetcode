package io.been.leetcode;

public class Leetcode1373 {
    private int res;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode cur) {
        if (cur == null) return null;
        int[] left = dfs(cur.left);
        int[] right = dfs(cur.right);
        int[] info = {1, cur.val, cur.val, cur.val};
        if (left != null && (left[3] >= cur.val || left[0] == 0)
                || right != null && (right[2] <= cur.val || right[0] == 0)) {
            info[0] = 0;
            return info;
        }
        info[1] += (left != null ? left[1] : 0) + (right != null ? right[1] : 0);
        if (left != null) {
            info[2] = left[2];
        }
        if (right != null) {
            info[3] = right[3];
        }
        res = Math.max(res, info[1]);
        return info;
    }
}
