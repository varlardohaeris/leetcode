package io.been.leetcode;

public class Leetcode214 {
    public String shortestPalindrome(String s) {
        int i = 0;
        int n = s.length();
        for (int j = n - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) ++i;
        }

        if (i == n) return s;
        String rem = s.substring(i);
        String rem_rev = new StringBuffer(rem).reverse().toString();
        return rem_rev + shortestPalindrome(s.substring(0, i)) + rem;
    }
}
