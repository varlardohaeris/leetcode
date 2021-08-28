package io.been.leetcode;

import java.util.Arrays;

public class Leetcode1371 {
    public int findTheLongestSubstring(String s) {
        int[] pos = new int[32];
        Arrays.fill(pos, -2);
        pos[0] = -1;
        int status = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'a':
                    status ^= 1;
                    break;
                case 'e':
                    status ^= (1 << 1);
                    break;
                case 'i':
                    status ^= (1 << 2);
                    break;
                case 'o':
                    status ^= (1 << 3);
                    break;
                case 'u':
                    status ^= (1 << 4);
                    break;
                default:
                    break;
            }
            if (pos[status] >= -1) {
                res = Math.max(res, i - pos[status]);
            } else {
                pos[status] = i;
            }
        }
        return res;
    }
}
