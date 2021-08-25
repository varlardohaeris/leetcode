package io.been;

public class Leetcode66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i + 1] = digits[i];
        }
        return res;
    }
}
