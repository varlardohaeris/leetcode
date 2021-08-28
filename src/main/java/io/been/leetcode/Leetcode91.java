package io.been.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode91 {
    private Map<String, Integer> map = new HashMap<>();

    public int numDecodings(String s) {
        return bt(s);
    }

    private int bt(String s) {
        if (map.containsKey(s)) return map.get(s);
        if (s.length() > 0 && s.charAt(0) == '0') return 0;
        if (s.length() <= 1) return 1;
        int res = bt(s.substring(1));
        String front = s.substring(0, 2);
        int num = Integer.parseInt(front);
        if (num <= 26) {
            res += bt(s.substring(2));
        }
        map.put(s, res);
        return res;
    }

}
