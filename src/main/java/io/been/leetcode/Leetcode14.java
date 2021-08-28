package io.been.leetcode;

public class Leetcode14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            int k = 0;
            while (k < Math.min(prefix.length(), s.length())) {
                if (prefix.charAt(k) != s.charAt(k)) {
                    break;
                }
                k++;
            }
            prefix = prefix.substring(0, k);
        }
        return prefix;
    }
}
