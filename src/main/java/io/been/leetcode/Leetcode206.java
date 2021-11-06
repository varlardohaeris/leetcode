package io.been.leetcode;

public class Leetcode206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverse(ListNode head) {
        ListNode temp = new ListNode(-1);
        temp.next = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = temp.next;
            temp.next = head;
            head = next;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode res = new Leetcode206().reverseList(head);
        System.out.println(res.val);
    }
}
