package io.been.leetcode;

public class Leetcode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l = head;
        ListNode r = head;
        ListNode pre = dummy;
        for (int i = 1; i < left; i++) {
            pre = l;
            l = l.next;
        }
        for (int i = 1; i < right; i++) {
            r = r.next;
        }
        while (l != r) {
            pre.next = l.next;
            l.next = r.next;
            r.next = l;
            l = pre.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5)))));
        ListNode res = new Leetcode92().reverseBetween(head, 2, 4);
        System.out.println(res.val);
    }
}
