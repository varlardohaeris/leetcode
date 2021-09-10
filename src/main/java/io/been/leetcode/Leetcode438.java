package io.been.leetcode;

import java.util.*;

public class Leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] window = new int[26];
        int[] needs = new int[26];
        Set<Character> set = new HashSet<>();
        for (char c : p.toCharArray()) {
            needs[c - 'a']++;
            set.add(c);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (needs[c - 'a'] > 0) {
                window[c - 'a']++;
                if (window[c - 'a'] == needs[c - 'a']) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                if (valid == set.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (needs[d - 'a'] > 0) {
                    if (window[d - 'a'] == needs[d - 'a']) {
                        valid--;
                    }
                    window[d - 'a']--;
                }
            }
        }
        return res;
    }
}
