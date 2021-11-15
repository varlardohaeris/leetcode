#include "../include/listnode.h"

#include <algorithm>
#include <climits>
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
    int maxSubArray(vector<int>& nums) {
        int res = INT_MIN;
        for (int i = 0, last = 0; i < nums.size(); i++) {
            last = nums[i] + max(last, 0);
            res = max(res, last);
        }
        return res;
    }
};
