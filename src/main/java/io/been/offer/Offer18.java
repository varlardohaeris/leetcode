package io.been.offer;

import io.been.leetcode.ListNode;

public class Offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }

        pre.next = cur.next;
        return head;
    }
}
