#include "./include/listnode.h"

#include <algorithm>
#include <queue>
#include <stack>
#include <string>
#include <unordered_map>
#include <utility>
#include <vector>

using namespace std;
// todo
class Solution {
  public:
    int longestValidParentheses(string s) {
        stack<int> stack;
        int res = 0;
        for (int i = 0, start = -1; i < s.size(); i++) {
            if (s[i] == '(') {
                stack.push(i);
            } else {
                if (stack.size() > 0) {
                    stack.pop();
                    if (stack.size() > 0) {
                        res = max(res, i - stack.top());
                    } else {
                        res = max(res, i - start);
                    }
                } else {
                    start = i;
                }
            }
        }
        return res;
    }
};
