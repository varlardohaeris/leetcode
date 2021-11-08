#include <limits.h>
#include <string>

using namespace std;

class Solution {
  public:
    int myAtoi(string s) {
        int k = 0;
        while (k < s.size() && s[k] == ' ') {
            k++;
        }
        if (k == s.size()) {
            return 0;
        }
        int minus = 1;
        if (s[k] == '-') {
            minus = -1;
            k++;
        } else if (s[k] == '+') {
            k++;
        }

        long long res = 0;
        while (k < s.size() && s[k] >= '0' && s[k] <= '9') {
            res = res * 10 + s[k] - '0';
            k++;
            if (res > INT_MAX) {
                break;
            }
        }

        res *= minus;
        if (res > INT_MAX) {
            res = INT_MAX;
        }
        if (res < INT_MIN) {
            res = INT_MIN;
        }
        return res;
    }
};