package io.been.leetcode;

import java.util.*;

public class Leetcode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, Boolean> mem = new HashMap<>();

        return solve(s, mem, dict);
    }

    private boolean solve(String s, Map<String, Boolean> mem, Set<String> dict) {
        if (mem.containsKey(s)) return mem.get(s);
        if (dict.contains(s)) {
            mem.put(s, true);
            return true;
        }

        for (int i = 1; i < s.length(); i++) {
            if (dict.contains(s.substring(i)) && solve(s.substring(0, i), mem, dict)) {
                mem.put(s, true);
                return true;
            }
        }
        mem.put(s, false);
        return false;
    }
}
