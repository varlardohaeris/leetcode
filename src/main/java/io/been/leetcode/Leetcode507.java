package io.been.leetcode;

public class Leetcode507 {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder builder = new StringBuilder();
        boolean negative = false;
        if (num < 0) {
            num = -num;
            negative = true;
        }
        while (num > 0) {
            builder.append(num % 7);
            num /= 7;
        }
        return negative ? "-" + builder.reverse().toString() : builder.reverse().toString();
    }
}
