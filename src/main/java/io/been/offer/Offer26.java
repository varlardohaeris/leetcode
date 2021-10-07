package io.been.offer;

import io.been.leetcode.TreeNode;

public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return isSub(A, B)
                || isSubStructure(A.left, B)
                || isSubStructure(A.right, B);
    }

    private boolean isSub(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;
        if (A.val != B.val) return false;
        return isSub(A.left, B.left)
                && isSub(A.right, B.right);
    }
}
