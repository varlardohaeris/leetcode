package io.been;

public class Leetcode1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int maxLeft = values[0];
        int max = 0;
        for (int j = 1; j < values.length; j++) {
            max = Math.max(max, maxLeft + values[j] - j);
            maxLeft = Math.max(maxLeft, values[j] + j);
        }
        return max;
    }
}
