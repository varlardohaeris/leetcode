package io.been.leetcode;

public class Leetcode394 {
    private int i = 0;

    public String decodeString(String s) {
        int len = s.length();
        if (len < 1) return "";
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder("");
        while (i < len) {
            int times = 0;
            while (i < len && chars[i] <= '9' && chars[i] >= '0') {
                times = times * 10 + (chars[i] - '0');
                i++;
            }
            if (chars[i] == '[') {
                i++;
                String word = decodeString(s);
                while (times > 0) {
                    times--;
                    builder.append(word);
                }
            } else if (chars[i] == ']') {
                i++;
                return builder.toString();
            } else {
                builder.append(chars[i]);
                i++;
            }
        }
        return builder.toString();
    }
}
