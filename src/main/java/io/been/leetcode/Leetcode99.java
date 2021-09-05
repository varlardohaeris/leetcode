package io.been.leetcode;

public class Leetcode99 {
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        boolean firstTime = true;

        while (root != null) {
            if (root.left != null) {
                TreeNode temp = root.left;
                while (temp.right != null && temp.right != root) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = root;
                    root = root.left;
                } else {
                    temp.right = null;
                    if (root.val < pre.val && firstTime) {
                        first = pre;
                        firstTime = false;
                    }
                    if (root.val < pre.val && !firstTime) {
                        second = root;
                    }
                    pre = root;
                    root = root.right;
                }
            } else {
                if (root.val < pre.val && firstTime) {
                    first = pre;
                    firstTime = false;
                }
                if (root.val < pre.val && !firstTime) {
                    second = root;
                }
                pre = root;
                root = root.right;
            }
        }
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
