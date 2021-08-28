package io.been.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            curr.next = pq.peek();
            curr = curr.next;
            pq.poll();
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }
        return dummy.next;
    }
}
