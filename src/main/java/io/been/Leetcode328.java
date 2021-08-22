package io.been;

public class Leetcode328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);
        ListNode odd = oddDummy;
        ListNode even = evenDummy;
        while (head != null) {
            odd.next = head;
            even.next = head.next;
            odd = odd.next;
            even = even.next;
            ListNode next = null;
            if (head.next != null) {
                next = head.next.next;
            }
            head = next;
        }
        odd.next = evenDummy.next;
        return oddDummy.next;
    }
}
