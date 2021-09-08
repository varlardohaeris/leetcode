package io.been.leetcode;

public class Leetcode647 {
    private String s;
    private int res;

    public int countSubstrings(String s) {
        if (s.length() == 0) return 0;
        int n = s.length();
        this.res = 0;
        this.s = s;

        for (int i = 0; i < n; i++) {
            count(i, i);
            count(i, i + 1);
        }
        return res;
    }

    private void count(int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            res++;
            start--;
            end++;
        }
    }
}
