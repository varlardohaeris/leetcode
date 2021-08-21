package io.been;

public class Leetcode203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = head;
        ListNode dummy;
        while (pre != null && pre.val == val) {
            pre = pre.next;
        }
        dummy = pre;
        if (dummy == null) return null;
        ListNode cur = pre.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy;
    }
}
