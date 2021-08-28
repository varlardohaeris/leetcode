package io.been.leetcode;

public class Leetcode202 {
    public int squareSum(int x) {
        int sum = 0;
        int cur = 0;
        while (x > 0) {
            cur = x % 10;
            sum += cur * cur;
            x = x / 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        } while (slow != fast);
        return slow == 1;
    }
}
