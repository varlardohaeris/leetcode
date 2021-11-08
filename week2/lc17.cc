#include <algorithm>
#include <string>
#include <unordered_map>
#include <utility>
#include <vector>

using namespace std;

class Solution {
  public:
    vector<string> ans;
    string strs[10] = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    vector<string> letterCombinations(string digits) {
        if (digits.size() == 0) {
            return ans;
        }
        dfs(digits, 0, "");
        return ans;
    }
    void dfs(string& digits, int start, string path) {
        if (start == digits.size()) {
            ans.push_back(path);
        } else {
            for (auto c : strs[digits[start] - '0']) {
                dfs(digits, start + 1, path + c);
            }
        }
    }
};
