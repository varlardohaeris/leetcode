package io.been.leetcode;

public class Leetcode382 {
    class Solution {
        private ListNode head;

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            this.head = head;
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            int winner = head.val;
            ListNode cur = head;
            for (int i = 1; cur.next != null; i++) {
                cur = cur.next;
                if (getRandomNum(i + 1) == i) {
                    winner = cur.val;
                }
            }
            return winner;
        }

        private int getRandomNum(int n) {
            return (int) (Math.random() * n);
        }
    }
}
