package io.been.leetcode;

public class Leetcode106 {
    private int[] postorder;
    private int[] inorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        return buildTree(0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int st1, int end1, int st2, int end2) {
        if (st1 > end1|| st2 > end2) return null;
        TreeNode node = new TreeNode(postorder[end2]);
        int mid = -1;
        for (int i = st1; i <= end1; i++) {
            if (inorder[i] == node.val) {
                mid = i;
                break;
            }
        }
        int len = mid - st1;
        node.left = buildTree(st1, mid - 1, st2, st2 + len - 1);
        node.right = buildTree(mid + 1, end1, st2 + len, end2 - 1);
        return node;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = new Leetcode106().buildTree(inorder, postorder);
        System.out.println(root.val);
    }
}
