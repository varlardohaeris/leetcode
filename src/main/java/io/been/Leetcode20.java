package io.been;

import java.util.Stack;

public class Leetcode20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    char v = stack.peek();
                    if ((c == ')' && v == '(')
                            || (c == '}' && v == '{')
                            || (c == ']' && v == '[')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
