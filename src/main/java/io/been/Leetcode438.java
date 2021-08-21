package io.been;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        int start = 0;
        int left = 0;
        int right = 0;
        int match = 0;
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();
        for (char c : p.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (needs.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if (window.get(c1).equals(needs.get(c1))) {
                    match++;
                }
            } else {
                left = right + 1;
                window = new HashMap<>();
                match = 0;
            }
            right++;

            while (match == needs.size()) {
                start = left;
                if (window.equals(needs)) res.add(start);
                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    window.put(c2, window.get(c2) - 1);
                    if (window.get(c2) < needs.get(c2)) {
                        match--;
                    }
                }
                left++;
            }
        }
        return res;
    }
}
