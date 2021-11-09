#include "./include/listnode.h"

#include <algorithm>
#include <queue>
#include <stack>
#include <string>
#include <unordered_map>
#include <utility>
#include <vector>

using namespace std;

class Solution {
  public:
    struct Cmp {
        bool operator()(ListNode* a, ListNode* b) { return a->val > b->val; }
    };
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if (lists.size() == 0) {
            return nullptr;
        }

        priority_queue<ListNode*, vector<ListNode*>, Cmp> heap;
        auto dummy = new ListNode(-1);
        auto tail = dummy;
        for (auto l : lists) {
            if (l != nullptr) {
                heap.push(l);
            }
        }
        while (heap.size() > 0) {
            auto t = heap.top();
            heap.pop();
            tail->next = t;
            tail = tail->next;
            if (t->next != nullptr) {
                heap.push(t->next);
            }
        }
        return dummy->next;
    }
};
