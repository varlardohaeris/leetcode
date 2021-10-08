package io.been.leetcode;

public class Leetcode434 {
    public int countSegments(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; ) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            while (i < n && s.charAt(i) != ' ') i++;
            ans++;
        }
        return ans;
    }
}
