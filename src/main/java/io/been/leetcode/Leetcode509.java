package io.been.leetcode;

public class Leetcode509 {
    public int fib(int n) {
        if (n <= 1) return n;
        int dp0 = 0;
        int dp1 = 1;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum = dp0 + dp1;
            dp0 = dp1;
            dp1 = sum;
        }
        return sum;
    }
}
