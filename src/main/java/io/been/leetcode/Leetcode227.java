package io.been.leetcode;

public class Leetcode227 {
    public  static  int calculate(String s) {
        s = s.trim().replaceAll(" ", "");
        int len = s.length();
        char[] cs = s.toCharArray();
        char sign = '+';
        int prev = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int c = 0;
            while (i < len && cs[i] >= '0' && cs[i] <= '9') {
                c = c * 10 + (cs[i] - '0');
                i++;
            }
            if (sign == '+') {
                ans += prev;
                prev = c;
            } else if (sign == '-') {
                ans += prev;
                prev = -c;
            } else if (sign == '*') {
                prev *= c;
            } else {
                prev /= c;
            }
            if (i + 1 < len) {
                sign = cs[i];
            }
        }
        return ans + prev;
    }

    public static void main(String[] args) {
        calculate("3 + 2 * 2");
    }
}
