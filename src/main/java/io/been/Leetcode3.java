package io.been;

import java.util.Arrays;

public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] ids = new int[128];
        Arrays.fill(ids, -1);
        int ans = 0;
        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(i, ids[s.charAt(j)] + 1);
            ans = Math.max(ans, j - i + 1);
            ids[s.charAt(j)] = j;
        }
        return ans;
    }
}
