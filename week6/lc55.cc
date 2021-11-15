#include "../include/listnode.h"

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
    bool canJump(vector<int>& nums) {
        for (int i = 0, j = 0; i < nums.size(); i++) {
            if (j < i) {
                return false;
            }
            j = max(j, nums[i] + i);
        }
        return true;
    }
};
