package io.been.leetcode;

public class Leetcode1344 {
    public double angleClock(int hour, int minutes) {
        double hourHand = (hour + minutes / 60.0) * 30;
        double minHand = minutes * 6;
        double dist = Math.abs(hourHand - minHand);
        return Math.min(dist, 360 - dist);
    }
}
