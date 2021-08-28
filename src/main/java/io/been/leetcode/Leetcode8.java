package io.been.leetcode;

public class Leetcode8 {
    public int myAtoi(String s) {
        if (s == null || s.equals("")) return 0;
        while (s.length() > 0 && s.charAt(0) == ' ') {
            s = s.substring(1);
        }
        if (s.length() == 0) return 0;
        int sign = 1;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            if (s.charAt(0) == '-') sign = -1;
            s = s.substring(1);
        }

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                break;
            }
            int v = s.charAt(i) - '0';
            if (res > Integer.MAX_VALUE / 10) {
                if (sign == 1) return Integer.MAX_VALUE;
                if (sign == -1) return Integer.MIN_VALUE;
            } else if (res == Integer.MAX_VALUE / 10) {
                if (sign == 1 && v >= 7) return Integer.MAX_VALUE;
                if (sign == -1 && v >= 8) return Integer.MIN_VALUE;
            }
            res = 10 * res + v;
        }
        return res * sign;
    }

    public static void main(String[] args) {
        int res = new Leetcode8().myAtoi(" ");
        System.out.println(res);
    }
}
