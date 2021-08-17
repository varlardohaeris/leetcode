package io.been;

import java.util.HashMap;
import java.util.Map;

public class Leetcode13 {
    public int romanToInt(String s) {
        Map<Character, Integer> table = new HashMap<>();
        table.put('I', 1);
        table.put('V', 5);
        table.put('X', 10);
        table.put('L', 50);
        table.put('C', 100);
        table.put('D', 500);
        table.put('M', 1000);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && table.get(s.charAt(i)) < table.get(s.charAt(i + 1))) {
                res -= table.get(s.charAt(i));
            } else {
                res += table.get(s.charAt(i));
            }
        }
        return res;
    }
}
