package io.been;

public class Leetcode430 {
    private Node prev;

    public Node flatten(Node head) {
        if (head == null) return null;
        if (prev != null) {
            prev.next = head;
            head.prev = prev;
            prev.child = null;
        }
        prev = head;
        Node next = head.next;
        flatten(head.child);
        flatten(next);
        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
