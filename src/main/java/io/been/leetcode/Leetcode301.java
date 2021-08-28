package io.been.leetcode;

import java.util.*;

public class Leetcode301 {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(s);
        visited.add(s);
        int errors = errors(s);
        while (!queue.isEmpty() && errors > 0) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String str = queue.poll();
                int i = 0;
                while (i < str.length()) {
                    if (str.charAt(i) != '(' && str.charAt(i) != ')') {
                        i++;
                        continue;
                    }
                    String temp = str.substring(0, i) + str.substring(i + 1);
                    if (!visited.contains(temp)) {
                        int cur_errors = errors(temp);
                        if (cur_errors < errors) {
                            queue.add(temp);
                            visited.add(temp);
                        }
                    }
                    while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                        i++;
                    }
                    i++;
                }
            }
            errors--;
        }
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        return res;
    }

    private int errors(String s) {
        Stack<Character> stack = new Stack<>();
        int valid = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    valid += 2;
                    stack.pop();
                }
            } else {
                valid++;
            }
        }
        return s.length() - valid;
    }
}
