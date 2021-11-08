#include "./include/listnode.h"

class Solution {
  public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* dummy = new ListNode(-1);
        ListNode* cur = dummy;
        int t = 0;
        while (l1 != nullptr || l2 != nullptr || t != 0) {
            if (l1 != nullptr) {
                t += l1->val;
                l1 = l1->next;
            }
            if (l2 != nullptr) {
                t += l2->val;
                l2 = l2->next;
            }
            cur->next = new ListNode(t % 10);
            cur = cur->next;
            t /= 10;
        }
        return dummy->next;
    }
}