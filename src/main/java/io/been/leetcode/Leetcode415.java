package io.been.leetcode;

public class Leetcode415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while (carry == 1 || i >= 0 || j >= 0) {
            int x = i < 0 ? 0 : num1.charAt(i--) - '0';
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';
            builder.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }
}
