package io.been.leetcode;

public class Leetcode151 {
    public String reverseWords(String s) {
        String[] str = s.trim().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (!str[i].equals("")) {
                builder.append(str[i] + ' ');
            }
        }
        return builder.toString().trim();
    }
}
