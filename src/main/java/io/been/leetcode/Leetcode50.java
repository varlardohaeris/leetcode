package io.been.leetcode;

public class Leetcode50 {
    public double myPow(double x, int n) {
        double a = pow(x, Math.abs(n));
        if (n < 0) {
            return 1 / a;
        } else {
            return a;
        }
    }

    private double pow(double x, int n) {
        if (n == 0) return 1;
        double a = pow(x, n / 2);
        if (n % 2 == 0) {
            return a * a;
        } else {
            return a * a * x;
        }
    }
}
