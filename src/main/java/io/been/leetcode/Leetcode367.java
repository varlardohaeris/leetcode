package io.been.leetcode;

public class Leetcode367 {
    public boolean isPerfectSquare(int num) {
        int sum = 1;
        while (num > 0) {
            num -= sum;
            sum += 2;
        }
        return num == 0;
    }
}
