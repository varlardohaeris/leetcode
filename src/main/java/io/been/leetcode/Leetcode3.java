package io.been.leetcode;

public class Leetcode3 {
    public static int lengthOfLongestSubstring(String s) {
        int[] window = new int[128];
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window[c]++;
            while (window[c] > 1) {
                char d = s.charAt(left);
                left++;
                window[d]--;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
