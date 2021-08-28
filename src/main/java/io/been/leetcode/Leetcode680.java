package io.been.leetcode;

public class Leetcode680 {
    public boolean validPalindrome(String s) {
        return dfs(s, 1);
    }

    public boolean dfs(String s, int count) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                if (count == 0) return false;
                String s1 = s.substring(start + 1, end + 1);
                String s2 = s.substring(start, end);
                return dfs(s1, count - 1) || dfs(s2, count - 1);
            }
            start++;
            end--;
        }
        return true;
    }
}
