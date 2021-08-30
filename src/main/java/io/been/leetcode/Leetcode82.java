package io.been.leetcode;

public class Leetcode82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        if (head.val == next.val) {
            while (next != null && head.val == next.val) {
                next = next.next;
            }
            return deleteDuplicates(next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
