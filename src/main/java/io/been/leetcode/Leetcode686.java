package io.been.leetcode;

public class Leetcode686 {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder builder = new StringBuilder(a);
        int count = 1;
        while (builder.length() < b.length()) {
            builder.append(a);
            count++;
        }
        if (builder.indexOf(b) >= 0) {
            return count;
        }
        builder.append(a);
        if (builder.indexOf(b) >= 0) {
            return count + 1;
        }
        return -1;
    }
}
