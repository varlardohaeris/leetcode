package io.been.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode451 {
    public String frequencySort(String s) {
        int n = s.length();
        int[] freq = new int[256];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i)]++;
        }
        List<Character>[] bucket = new ArrayList[n + 1];
        for (int i = 0; i < freq.length; i++) {
            int f = freq[i];
            if (f > 0) {
                if (bucket[f] == null) {
                    bucket[f] = new ArrayList<>();
                }
                bucket[f].add((char) i);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = n; i >= 0; i--) {
            if (bucket[i] != null) {
                for (Character c : bucket[i]) {
                    for (int j = 0; j < i; j++) {
                        builder.append(c);
                    }
                }
            }
        }
        return builder.toString();
    }
}
