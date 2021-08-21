package io.been;

public class Leetcode234 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode first = slow.next;
        ListNode reverseHead = null;
        while (first != null) {
            ListNode second = first.next;
            first.next = reverseHead;
            reverseHead = first;
            first = second;
        }

        while (reverseHead != null) {
            if (reverseHead.val != head.val) {
                return false;
            }
            reverseHead = reverseHead.next;
            head = head.next;
        }
        return true;
    }
}
