package io.been;

import java.util.*;

public class Leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> cache = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!cache.containsKey(key)) {
                cache.put(key, new ArrayList<>());
            }
            cache.get(key).add(strs[i]);
        }
        for (List<String> list : cache.values()) {
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}
