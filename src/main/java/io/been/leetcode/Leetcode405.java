package io.been.leetcode;

public class Leetcode405 {
    public String toHex(int num) {
        char[] dict = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        if (num == 0) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        while (num != 0) {
            builder.append(dict[num & 0b1111]);
            num >>>= 4;
        }
        return builder.reverse().toString();
    }
}
