package io.been.leetcode;

public class Leetcode953 {
    private int[] orders = new int[26];

    public boolean isAlienSorted(String[] words, String order) {
        char[] chars = order.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            orders[chars[i] - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            String pre = words[i - 1];
            String cur = words[i];
            if (!check(pre, cur)) {
                return false;
            }
        }
        return true;
    }

    private boolean check(String pre, String cur) {
        int len = Math.min(pre.length(), cur.length());
        for (int i = 0; i < len; i++) {
            char p = pre.charAt(i);
            char c = cur.charAt(i);
            if (orders[p - 'a'] < orders[c - 'a']) return true;
            if (orders[p - 'a'] > orders[c - 'a']) return false;
        }
        return pre.length() <= cur.length();
    }
}
