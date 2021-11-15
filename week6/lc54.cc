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
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> res;
        int n = matrix.size();
        if (n == 0) {
            return res;
        }

        int m = matrix[0].size();
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};
        vector<vector<bool>> visited(n, vector<bool>(m));

        for (int i = 0, x = 0, y = 0, d = 0; i < n * m; i++) {
            res.push_back(matrix[x][y]);
            visited[x][y] = true;

            int a = x + dx[d];
            int b = y + dy[d];
            if (a < 0 || a >= n || b < 0 || b >= m || visited[a][b]) {
                d = (d + 1) % 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            x = a;
            y = b;
        }
        return res;
    }
};
