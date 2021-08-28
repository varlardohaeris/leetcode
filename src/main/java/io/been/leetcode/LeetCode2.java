package io.been.leetcode;

public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int num = sum % 10;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            cur.next = new ListNode(num);
            cur = cur.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            int num = sum % 10;
            carry = sum / 10;
            cur.next = new ListNode(num);
            cur = cur.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            int num = sum % 10;
            carry = sum / 10;
            cur.next = new ListNode(num);
            cur = cur.next;
            l2 = l2.next;
        }

        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(15 % 10); // 5
        System.out.println(15 / 10); // 1
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode listNode = new LeetCode2().addTwoNumbers(l1, l2);
        System.out.println(listNode.val);
        l1 = new ListNode(9, new ListNode(9, new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9,
                        new ListNode(9)))))));
        l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode node = new LeetCode2().addTwoNumbers(l1, l2);
        System.out.println(node.val);
    }
}
