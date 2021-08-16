package io.been;

import java.util.Stack;

public class Leetcode32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int t = stack.peek();
            if (t != -1 && s.charAt(i) == ')' && s.charAt(t) == '(') {
                stack.pop();
                res = Math.max(res, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return res;
    }
}
