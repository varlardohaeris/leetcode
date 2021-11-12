#include "./include/listnode.h"

#include <algorithm>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <utility>
#include <vector>

using namespace std;

class Solution {
  public:
    int trap(vector<int>& height) {
        stack<int> stack;
        int res = 0;
        for (int i = 0; i < height.size(); i++) {
            int last = 0;
            while (stack.size() > 0 && height[stack.top()] <= height[i]) {
                res += (height[stack.top()] - last) * (i - stack.top() - 1);
                last = height[stack.top()];
                stack.pop();
            }
            if (stack.size() > 0) {
                res += (i - stack.top() - 1) * (height[i] - last);
            }
            stack.push(i);
        }
        return res;
    }
};
