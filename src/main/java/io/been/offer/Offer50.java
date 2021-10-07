package io.been.offer;

import java.util.HashMap;
import java.util.Map;

public class Offer50 {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) != null) {
                map.put(c, false);
            } else {
                map.put(c, true);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c)) {
                return c;
            }
        }
        return ' ';
    }
}
