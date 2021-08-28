package io.been.leetcode;

public class Leetcode10 {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    private boolean isMatch(String s, int idx1, String p, int idx2) {
        if (idx2 >= p.length()) {
            return idx1 == s.length();
        }
        if ((idx2 + 1) < p.length() && p.charAt(idx2 + 1) == '*') {
            if (isMatch(s, idx1, p, idx2 + 2)) {
                return true;
            }
            if (idx1 < s.length() && (p.charAt(idx2) == '.' || s.charAt(idx1) == p.charAt(idx2))) {
                return isMatch(s, idx1 + 1, p, idx2);
            }
        } else if (idx1 < s.length() && (p.charAt(idx2) == '.' || s.charAt(idx1) == p.charAt(idx2))) {
            return isMatch(s, idx1 + 1, p, idx2 + 1);
        }
        return false;
    }
}
