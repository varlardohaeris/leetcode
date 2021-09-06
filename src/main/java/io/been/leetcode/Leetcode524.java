package io.been.leetcode;

import java.util.List;

public class Leetcode524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String word : dictionary) {
            int len1 = res.length();
            int len2 = word.length();
            if (len1 > len2 || (len1 == len2 && res.compareTo(word) < 0)) {
                continue;
            }
            if (isSubString(s, word)) {
                res = word;
            }
        }
        return res;
    }

    private boolean isSubString(String s, String word) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < s.length() & p2 < word.length()) {
            if (s.charAt(p1) == word.charAt(p2)) {
                p2++;
            }
            p1++;
        }
        if (p2 == word.length()) {
            return true;
        } else {
            return false;
        }
    }
}
