package io.been.leetcode;

public class Leetcode224 {
    private int index = 0;

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        int ans = get(s);
        return ans;
    }

    private int get(String s) {
        if (index >= s.length()) return 0;
        int res = 0;
        char sign = '+';
        while (index < s.length()) {
            int cur = 0;
            if (s.charAt(index) == '(') {
                index++;
                cur = get(s);
            } else {
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    cur = cur * 10 + (s.charAt(index) - '0');
                    index++;
                }
            }
            if (sign == '+') {
                res += cur;
            } else if (sign == '-') {
                res -= cur;
            }
            if (index < s.length() && s.charAt(index) == ')') {
                index++;
                break;
            }
            if (index < s.length()) {
                sign = s.charAt(index);
            }
            index++;
        }
        return res;
    }
}
