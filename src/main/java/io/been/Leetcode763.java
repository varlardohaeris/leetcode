package io.been;

import java.util.ArrayList;
import java.util.List;

public class Leetcode763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'] = i;
        }

        int last = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            last = Math.max(last, map[s.charAt(i) - 'a']);
            if (last == i) {
                res.add(last - start + 1);
                start = last + 1;
            }
        }
        return res;
    }
}
