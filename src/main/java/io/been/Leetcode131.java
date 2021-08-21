package io.been;

import java.util.ArrayList;
import java.util.List;

public class Leetcode131 {
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        List<String> cur = new ArrayList<>();
        bt(cur, s);
        return res;
    }

    private void bt(List<String> cur, String s) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i + 1))) {
                cur.add(s.substring(0, i + 1));
                bt(cur, s.substring(i + 1));
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 1) return true;
        int i = 0;
        int len = s.length();
        while (i <= len / 2) {
            if (s.charAt(i) != s.charAt(len - i - 1)) return false;
            i++;
        }
        return true;
    }
}
