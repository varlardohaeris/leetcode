package io.been;


import java.util.HashMap;

public class Leetcode76 {
    public String minWindow(String s, String t) {
        int start = 0;
        int end = 0;
        char[] sum = s.toCharArray();
        char[] sub = t.toCharArray();
        HashMap<Character, Integer> temp = new HashMap<>();
        String result = s + " ";
        int count = sub.length;
        for (int i = 0; i < sub.length; i++) {
            if (temp.containsKey(sub[i])) {
                temp.put(sub[i], temp.get(sub[i]) + 1);
            } else {
                temp.put(sub[i], 1);
            }
        }

        while (end < s.length()) {
            if (temp.containsKey(sum[end])) {
                int flag = temp.get(sum[end]);
                if (flag > 0) {
                    count--;
                }
                temp.put(sum[end], --flag);
            }
            end++;
            if (count == 0) {
                while (start < end && count == 0) {
                    if (temp.containsKey(sum[start])) {
                        int flag = temp.get(sum[start]);
                        if (flag >= 0) {
                            count++;
                            result = result.length() > end - start ?
                                    s.substring(start, end) : result;

                        }
                        temp.put(sum[start], flag + 1);
                    }
                    start++;
                }
            }
        }
        return result.length() == s.length() + 1 ? "" : result;
    }
}
