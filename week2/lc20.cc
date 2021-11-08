#include "./include/listnode.h"

#include <algorithm>
#include <stack>
#include <string>
#include <unordered_map>
#include <utility>
#include <vector>

using namespace std;

class Solution {
  public:
    bool isValid(string s) {
        stack<char> stack;
        for (auto c : s) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.size() > 0 && abs(stack.top() - c) <= 2) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
};