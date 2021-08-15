package io.been;


public class Leetcode116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {

        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return null;
        connect(root.left, root.right);
        return root;
    }

    private void connect(Node n1, Node n2) {
        if (n1 == null || n2 == null) return;
        n1.next = n2;
        connect(n1.left, n1.right);
        connect(n2.left, n2.right);
        connect(n1.right, n2.left);
    }

}
