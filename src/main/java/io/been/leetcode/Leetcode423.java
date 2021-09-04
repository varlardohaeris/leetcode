package io.been.leetcode;

public class Leetcode423 {
    public String originalDigits(String s) {
        int[] digit = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'z') digit[0]++;
            if (c == 'w') digit[2]++;
            if (c == 'u') digit[4]++;
            if (c == 'x') digit[6]++;
            if (c == 'g') digit[8]++;
            if (c == 'o') digit[1]++;
            if (c == 'h') digit[3]++;
            if (c == 'f') digit[5]++;
            if (c == 's') digit[7]++;
            if (c == 'i') digit[9]++;
        }
        digit[1] = digit[1] - digit[0] - digit[2] - digit[4];
        digit[3] -= digit[8];
        digit[5] -= digit[4];
        digit[7] -= digit[6];
        digit[9] = digit[9] - digit[5] - digit[6] - digit[8];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j < digit[i]; j++) {
                builder.append(i);
            }
        }
        return builder.toString();
    }
}
