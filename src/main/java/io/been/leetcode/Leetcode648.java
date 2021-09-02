package io.been.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class Leetcode648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>();
        set.addAll(dictionary);
        StringBuilder builder = new StringBuilder();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = 1; j <= words[i].length(); j++) {
                String root = words[i].substring(0, j);
                if (set.contains(root)) {
                    words[i] = root;
                }
            }
            builder.append(words[i] + " ");
        }
        return builder.toString().trim();
    }
}
