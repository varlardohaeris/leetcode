package io.been;

public class Leetcode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int len = 1;
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
            len++;
        }
        k %= len;
        if (k == 0) return head;
        ListNode prev = head;
        for (int i = 0; i < len - k - 1; i++) {
            prev = prev.next;
        }
        ListNode res = prev.next;
        prev.next = null;
        last.next = head;
        return res;
    }
}
