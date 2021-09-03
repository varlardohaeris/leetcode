package io.been.leetcode;

import java.util.Stack;

public class Leetcode316 {
    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        boolean[] used = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map[c - 'a'] > 0) {
                map[c - 'a']--;
            }
            if (used[c - 'a']) continue;
            while (!stack.isEmpty() && stack.peek() > c && map[stack.peek() - 'a'] > 0) {
                used[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            used[c - 'a'] = true;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }
}
