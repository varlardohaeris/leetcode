package io.been.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode76 {
    public static String minWindow(String s, String t) {
        int[] window = new int[128];
        int[] need = new int[128];
        Set<Character> set = new HashSet<>();
        for (char c : t.toCharArray()) {
            need[c - 'A']++;
            set.add(c);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need[c - 'A'] > 0) {
                window[c - 'A']++;
                if (window[c - 'A'] == need[c - 'A']) {
                    valid++;
                }
            }
            while (valid == set.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need[d - 'A'] > 0) {
                    if (window[d - 'A'] == need[d - 'A']) {
                        valid--;
                    }
                    window[d - 'A']--;
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
