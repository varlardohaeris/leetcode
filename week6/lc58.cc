#include "../include/listnode.h"

#include <algorithm>
#include <iterator>
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
    int lengthOfLastWord(string s) {
        for (int i = s.size() - 1; i >= 0; i--) {
            if (s[i] == ' ') {
                continue;
            }
            int j = i - 1;
            while (j >= 0 && s[j] != ' ') {
                j--;
            }
            return i - j;
        }
        return -1;
    }
};
