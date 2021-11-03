package io.been.leetcode;

import java.util.stream.IntStream;

public class Leetcode1011 {
    public int shipWithinDays(int[] weights, int days) {
        int left = getMax(weights);
        int right = sum(weights) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFinish(int[] weights, int days, int cap) {
        int i = 0;
        for (int day = 0; day < days; day++) {
            int maxCap = cap;
            while ((maxCap -= weights[i]) >= 0) {
                i++;
                if (i == weights.length) {
                    return true;
                }
            }
        }
        return false;
    }

    private int sum(int[] weights) {
        return IntStream.of(weights).sum();
    }

    private int getMax(int[] weights) {
        return IntStream.of(weights).max().getAsInt();
    }

}
