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
    vector<vector<int>> ans;
    vector<bool> visited;
    vector<vector<int>> permute(vector<int>& nums) {
        path = vector<int>(nums.size());
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
                path[u] = nums[i];
                visited[i] = true;
                dfs(nums, u + 1);
                visited[i] = false;
            }
        }
    }
};
