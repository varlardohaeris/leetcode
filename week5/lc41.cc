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
    int firstMissingPositive(vector<int>& nums) {
        int n = nums.size();
        if (n == 0) {
            return 1;
        }
        for (auto& x : nums) {
            if (x != INT_MIN) {
                x--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0 || nums[i] >= n) {
                continue;
            }
            while ((nums[i] >= 0 && nums[i] < n) && nums[i] != i &&
                   nums[i] != nums[nums[i]]) {
                swap(nums[i], nums[nums[i]]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i + 1;
            }
        }
        return n + 1;
    }
};
