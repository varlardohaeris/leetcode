package io.been.leetcode;

public class Leetcode306 {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) return false;
        for (int i = 1; i <= num.length() / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) {
                return false;
            }
            long first = Long.parseLong(num.substring(0, i));
            for (int j = 1; num.length() - i - j >= Math.max(i, j); j++) {
                if (num.charAt(i) == '0' && j > 1) {
                    break;
                }
                long second = Long.parseLong(num.substring(i, i + j));
                if (isValid(first, second, i + j, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(long first, long second, int start, String num) {
        if (start == num.length()) return true;
        second = second + first;
        first = second - first;
        String sum = second + "";
        return num.startsWith(sum, start)
                && isValid(first, second, start + sum.length(), num);
    }
}
