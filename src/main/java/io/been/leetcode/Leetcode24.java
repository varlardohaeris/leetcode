package io.been.leetcode;

public class Leetcode24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode new_head = head.next;
        head.next = swapPairs(new_head.next);
        new_head.next = head;
        return new_head;
    }
}
