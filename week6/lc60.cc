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
    string getPermutation(int n, int k) {
        string res;
        vector<bool> visited(10);
        for (int i = 0; i < n; i++) {
            int fact = 1;
            for (int j = 1; j <= n - i - 1; j++) {
                fact *= j;
            }
            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    if (fact < k) {
                        k -= fact;
                    } else {
                        res += to_string(j);
                        visited[j] = true;
                        break;
                    }
                }
            }
        }
        return res;
    }
};
