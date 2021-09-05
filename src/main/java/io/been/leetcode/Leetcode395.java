package io.been.leetcode;

public class Leetcode395 {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        boolean fullString = true;
        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i) - 'a'] > 0 && hash[s.charAt(i) - 'a'] < k) {
                fullString = false;
            }
        }
        if (fullString) return s.length();
        int begin = 0;
        int end = 0;
        int result = 0;
        while (end < s.length()) {
            if (hash[s.charAt(end) - 'a'] < k) {
                result = Math.max(result, longestSubstring(s.substring(begin, end), k));
                begin = end + 1;
            }
            end++;
        }
        result = Math.max(result, longestSubstring(s.substring(begin), k));
        return result;
    }
}
