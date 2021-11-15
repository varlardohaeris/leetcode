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
    int n;
    vector<bool> col, dg, udg;
    vector<vector<string>> ans;
    vector<string> path;
    vector<vector<string>> solveNQueens(int _n) {
        n = _n;
        col = vector<bool>(n);
        dg = vector<bool>(n * 2);
        udg = vector<bool>(n * 2);
        path = vector<string>(n, string(n, '.'));
        dfs(0);
        return ans;
    }

    void dfs(int u) {
        if (u == n) {
            ans.push_back(path);

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[u - i + n] && !udg[u + i]) {
                col[i] = dg[u - i + n] = udg[u + i] = true;
                path[u][i] = 'Q';
                dfs(u + 1);
                path[u][i] = '.';
                col[i] = dg[u - i + n] = udg[u + i] = false;
            }
        }
    }
};
