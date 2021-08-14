package io.been;


public class Leetcode105 {
    private int[] preorder;
    private int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return buildTree(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int st1, int end1, int st2, int end2) {
        if (st1 > end1) return null;
        TreeNode node = new TreeNode(preorder[st1]);
        int mid = -1;
        for (int i = st2; i <= end2; i++) {
            if (inorder[i] == node.val) {
                mid = i;
                break;
            }
        }
        int c = mid - st2;
        node.left = buildTree(st1 + 1, st1 + c, st2, mid - 1);
        node.right = buildTree(st1 + c + 1, end1, mid + 1, end2);
        return node;
    }

}
