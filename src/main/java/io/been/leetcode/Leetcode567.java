package io.been.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode567 {
    public boolean checkInclusion(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        int[] need = new int[26];
        int[] window = new int[26];
        for (char c : s1.toCharArray()) {
            need[c - 'a']++;
            set.add(c);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need[c - 'a'] > 0) {
                window[c - 'a']++;
                if (window[c - 'a'] == need[c - 'a']) {
                    valid++;
                }
            }
            while (right - left >= s1.length()) {
                if (valid == set.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (need[d - 'a'] > 0) {
                    if (window[d - 'a'] == need[d - 'a']) {
                        valid--;
                    }
                    window[d - 'a']--;
                }
            }
        }
        return false;
    }
}
