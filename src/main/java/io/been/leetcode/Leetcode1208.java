package io.been.leetcode;

public class Leetcode1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int curCost = 0;
        int curLen = 0;
        int left = 0;
        int maxLen = curLen;
        for (int right = 0; right < len; right++) {
            curCost += distance(s.charAt(right), t.charAt(right));
            curLen++;
            while (curCost > maxCost && left <= right) {
                curCost -= distance(s.charAt(left), t.charAt(left));
                curLen--;
                left++;
            }
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }

    private int distance(char a, char b) {
        int i = a - b;
        return i > 0 ? i : -i;
    }
}
