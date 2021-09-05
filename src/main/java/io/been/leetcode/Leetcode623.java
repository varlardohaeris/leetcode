package io.been.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int d = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                if (d == depth - 1) {
                    TreeNode left = new TreeNode(val);
                    TreeNode right = new TreeNode(val);
                    if (top.left != null) {
                        left.left = top.left;
                    }
                    if (top.right != null) {
                        right.right = top.right;
                    }
                    top.left = left;
                    top.right = right;
                    continue;
                }
                if (top.left != null) {
                    queue.offer(top.left);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                }
            }
            d++;
        }
        return root;
    }
}
