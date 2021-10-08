package io.been.offer;

import java.util.HashMap;
import java.util.Map;

public class Offer35 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            Node newNode = new Node(cur.val);
            map.put(cur, newNode);
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node valueCur = map.get(cur);
            Node keyNextNode = cur.next;
            Node valueNextNode = map.get(keyNextNode);
            valueCur.next = valueNextNode;
            Node keyRandomNode = cur.random;
            Node valueRandomNode = map.get(keyRandomNode);
            valueCur.random = valueRandomNode;
            cur = cur.next;
        }
        return map.get(head);
    }
}

