package io.been.leetcode;

public class Leetcode479 {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        int upperBound = (int) Math.pow(10, n) - 1;
        int lowerBound = upperBound / 10 + 1;
        long maxNumer = (long) upperBound * (long) upperBound;
        int half = (int) (maxNumer / (long) Math.pow(10, n));
        boolean found = false;
        long palindrom = 0;
        while (!found) {
            palindrom = createPalindrome(half);
            for (long i = upperBound; i >= lowerBound; i--) {
                if (i * i < palindrom) {
                    break;
                }
                if (palindrom % i == 0) {
                    found = true;
                    break;
                }
            }
            half--;
        }
        return (int) (palindrom % 1337);
    }

    private long createPalindrome(int n) {
        String pStr = n + new StringBuilder().append(n).reverse().toString();
        return Long.parseLong(pStr);
    }
}
