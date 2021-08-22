package io.been;

import java.util.Stack;

public class Leetcode402 {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            while (k > 0 && !stack.isEmpty() && digit < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        while (builder.length() > 0 && builder.charAt(builder.length() - 1) == '0') {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.length() == 0 ? "0" : builder.reverse().toString();
    }
}
