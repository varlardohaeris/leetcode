package io.been.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode720 {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return b.compareTo(a);
            }
        });

        for (int i = words.length - 1; i >= 0; i--) {
            if (buildWord(set, words[i])) {
                return words[i];
            }
        }
        return "";
    }

    private boolean buildWord(Set<String> dict, String word) {
        for (int i = 1; i < word.length(); i++) {
            if (!dict.contains(word.substring(0, i))) {
                return false;
            }
        }
        return true;
    }

}
