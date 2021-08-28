package io.been.leetcode;

public class Leetcode567 {
    public boolean checkInclusion(String s1, String s2) {
        int count = s1.length();
        int[] s1Freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
        }

        int[] s2Freq = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            s2Freq[c - 'a']++;
            if (s2Freq[c - 'a'] <= s1Freq[c - 'a']) {
                count--;
            }
            if (i >= s1.length()) {
                char h = s2.charAt(i - s1.length());
                s2Freq[h - 'a']--;
                if (s2Freq[h - 'a'] < s1Freq[h - 'a']) {
                    count++;
                }
            }
            if (count == 0) {
                return true;
            }
        }
        return false;
    }
}
