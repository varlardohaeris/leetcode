#include "./include/listnode.h"

#include <algorithm>
#include <queue>
#include <stack>
#include <string>
#include <unordered_map>
#include <utility>
#include <vector>

using namespace std;

class Solution {
  public:
    vector<vector<int>> ans;
    vector<int> path;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        dfs(candidates, 0, target);
        return ans;
    }

    void dfs(vector<int>& cs, int u, int target) {
        if (target == 0) {
            ans.push_back(path);
            return;
        }

        if (u == cs.size()) {
            return;
        }

        for (int i = 0; cs[u] * i <= target; i++) {
            dfs(cs, u + 1, target - cs[u] * i);
            path.push_back(cs[u]);
        }
        for (int i = 0; cs[u] * i <= target; i++) {
            path.pop_back();
        }
    }
};
