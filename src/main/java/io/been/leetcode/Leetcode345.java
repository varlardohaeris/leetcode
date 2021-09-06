package io.been.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode345 {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        char[] vowels = {'a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U'};
        for (char vowel : vowels) {
            set.add(vowel);
        }
        int low = 0;
        int high = s.length() - 1;
        char[] ans = new char[s.length()];

        while (low <= high) {
            char ch1 = s.charAt(low);
            char ch2 = s.charAt(high);
            if (!set.contains(ch1)) {
                ans[low++] = ch1;
            } else if (!set.contains(ch2)) {
                ans[high--] = ch2;
            } else {
                ans[low++] = ch2;
                ans[high--] = ch1;
            }
        }
        return new String(ans);
    }
}
