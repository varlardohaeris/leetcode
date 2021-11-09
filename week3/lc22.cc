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
    vector<string> ans;
    vector<string> generateParenthesis(int n) {
        dfs(n, 0, 0, "");
        return ans;
    }

    void dfs(int n, int lc, int rc, string seq) {
        if (lc == n && rc == n) {
            ans.push_back(seq);
        } else {
            if (lc < n) {
                dfs(n, lc + 1, rc, seq + "(");
            }
            if (rc < n && lc > rc) {
                dfs(n, lc, rc + 1, seq + ")");
            }
        }
    }
};
