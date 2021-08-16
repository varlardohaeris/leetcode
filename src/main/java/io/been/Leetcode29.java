package io.been;

public class Leetcode29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            if (divisor > 0) {
                return -1 + divide(dividend + divisor, divisor);
            } else {
                return 1 + divide(dividend - divisor, divisor);
            }
        }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        boolean positive = true;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            positive = false;
        }
        int new_dividend = Math.abs(dividend);
        int new_divisor = Math.abs(divisor);
        int result = 0;

        int power = 0;
        while (new_divisor <= (new_dividend >> 1)) {
            new_divisor = new_divisor << 1;
            power++;
        }

        while (power >= 0) {
            if (new_dividend >= new_divisor) {
                result += (1 << power);
                new_dividend -= new_divisor;
            }
            power--;
            new_divisor = new_divisor >> 1;
        }
        return positive ? result : -result;
    }
}
