package io.been.leetcode;

import java.util.*;

public class Leetcode187 {
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        if (s.length() <= 10) {
            return res;
        }
        Map<String, Integer> memo = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (memo.containsKey(sub)
                    && memo.get(sub) == 1
                    && !set.contains(sub)) {
                res.add(sub);
                set.add(sub);
                memo.put(sub, memo.get(sub) + 1);
            } else {
                memo.put(sub, 1);
            }
        }
        return res;
    }
}
