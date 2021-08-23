package io.been;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode1028 {
    public TreeNode recoverFromPreorder(String traversal) {
        Deque<Node> stack = new ArrayDeque<>();
        int depth = 0;
        int istart = 0;
        for (int i = 1; i < traversal.length(); i++) {
            char c = traversal.charAt(i);
            char p = traversal.charAt(i - 1);
            if (c == '-' && p != '-') {
                int val = Integer.parseInt(traversal.substring(istart, i));
                while (!stack.isEmpty() && stack.peekLast().depth >= depth) {
                    Node child = stack.removeLast();
                    buildTree(stack.peekLast(), child);
                }
                stack.addLast(new Node(new TreeNode(val), depth));
                depth = 1;
                istart = i + 1;
            }
            if (c == '-' && p == '-') {
                depth++;
                istart = i + 1;
            }
        }
        int val = Integer.parseInt(traversal.substring(istart, traversal.length()));
        while (!stack.isEmpty() && stack.peekLast().depth >= depth) {
            Node child = stack.removeLast();
            buildTree(stack.peekLast(), child);
        }
        stack.addLast(new Node(new TreeNode(val), depth));
        while (stack.size() > 1) {
            Node child = stack.removeLast();
            buildTree(stack.peekLast(), child);
        }
        return stack.peekFirst().node;
    }

    public void buildTree(Node parent, Node child) {
        if (parent.node.left == null) {
            parent.node.left = child.node;
        } else {
            parent.node.right = child.node;
        }
    }

    class Node {
        TreeNode node;
        int depth;

        public Node(TreeNode n, int depth) {
            this.node = n;
            this.depth = depth;
        }
    }
}
