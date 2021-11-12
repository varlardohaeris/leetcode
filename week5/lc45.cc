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
    int jump(vector<int>& nums) {
        int n = nums.size();
        vector<int> f(n);
        for (int i = 1, j = 0; i < n; i++) {
            while (j + nums[j] < i) {
                j++;
            }
            f[i] = f[j] + 1;
        }
        return f[n - 1];
    }
};