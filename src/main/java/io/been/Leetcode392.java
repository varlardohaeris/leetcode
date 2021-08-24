package io.been;

public class Leetcode392 {
    public boolean isSubsequence(String s, String t) {
        int si = 0;
        int slen = s.length();
        int tlen = t.length();
        for (int i = 0; i < tlen; i++) {
            if (si == slen) {
                return true;
            }
            if (t.charAt(i) == s.charAt(si)) {
                si++;
            }
        }
        return si == slen;
    }
}
