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
    void nextPermutation(vector<int>& nums) {
        int k = nums.size() - 1;
        while (k > 0 && nums[k - 1] > nums[k]) {
            k--;
        }
        if (k <= 0) {
            reverse(nums.begin(), nums.end());
        } else {
            int t = k;
            while (t < nums.size() && nums[t] > nums[k - 1]) {
                t++;
            }
            swap(nums[t - 1], nums[k - 1]);
            reverse(nums.begin() + k, nums.end());
        }
    }
};
