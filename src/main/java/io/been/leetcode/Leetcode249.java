package io.been.leetcode;

import java.util.*;

public class Leetcode249 {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            char[] arr = s.toCharArray();
            if (arr.length > 0) {
                int diff = arr[0] - 'a';
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] - diff < 'a') {
                        arr[i] = (char) (arr[i] - diff + 26);
                    } else {
                        arr[i] = (char) (arr[i] - diff);
                    }
                }
            }
            String ns = new String(arr);
            if (map.containsKey(ns)) {
                map.get(ns).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(ns, list);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }
        result.addAll(map.values());
        return result;
    }
}
