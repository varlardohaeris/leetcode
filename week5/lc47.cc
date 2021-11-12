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
    vector<int> path;
    vector<bool> visited;
    vector<vector<int>> ans;
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        path = vector<int>(nums.size());
        sort(nums.begin(), nums.end());
        visited = vector<bool>(nums.size());
        dfs(nums, 0);
        return ans;
    }
    void dfs(vector<int>& nums, int u) {
        if (u == nums.size()) {
            ans.push_back(path);
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (visited[i] == false) {
                if (i > 0 && nums[i] == nums[i - 1] &&
                    visited[i - 1] == false) {
                    continue;
                }
                visited[i] = true;
                path[u] = nums[i];
                dfs(nums, u + 1);
                visited[i] = false;
            }
        }
    }
};
