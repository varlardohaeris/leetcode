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
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> res;
        if (intervals.size() == 0) {
            return res;
        }

        sort(intervals.begin(), intervals.end());

        int l = intervals[0][0];
        int r = intervals[0][1];

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals[i][0] > r) {
                res.push_back({l, r});
                l = intervals[i][0];
                r = intervals[i][1];
            } else {
                r = max(r, intervals[i][1]);
            }
        }
        res.push_back({l, r});
        return res;
    }
};
