#include <string>
using namespace std;

class Solution {
  public:
    string longestPalindrome(string s) {
        string res;
        for (int i = 0; i < s.size(); i++) {
            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && r < s.size() && s[l] == s[r]) {
                l--;
                r++;
            }
            if (res.size() < r - l - 1) {
                res = s.substr(l + 1, r - l - 1);
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < s.size() && s[l] == s[r]) {
                l--;
                r++;
            }
            if (res.size() < r - l - 1) {
                res = s.substr(l + 1, r - l - 1);
            }
        }
        return res;
    }
};