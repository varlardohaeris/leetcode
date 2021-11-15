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
    vector<vector<int>> insert(vector<vector<int>>& a, vector<int>& b) {
        vector<vector<int>> res;
        int k = 0;
        while (k < a.size() && a[k][1] < b[0]) {
            res.push_back(a[k++]);
        }

        if (k < a.size()) {
            b[0] = min(b[0], a[k][0]);
            while (k < a.size() && a[k][0] <= b[1]) {
                b[1] = max(b[1], a[k++][1]);
            }
        }

        res.push_back(b);

        while (k < a.size()) {
            res.push_back(a[k++]);
        }
        return res;
    }
};
