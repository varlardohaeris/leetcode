package io.been;

public class Leetcode67 {
    public String addBinary(String a, String b) {
        int ai = a.length() - 1;
        int bi = b.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while (ai >= 0 || bi >= 0) {
            int cur = carry;
            if (ai >= 0) {
                cur += a.charAt(ai--) - '0';
            }
            if (bi >= 0) {
                cur += b.charAt(bi--) - '0';
            }
            builder.append("" + cur % 2);
            carry = cur / 2;
        }
        while (carry > 0) {
            builder.append("" + carry % 2);
            carry /= 2;
        }
        return builder.reverse().toString();
    }
}
