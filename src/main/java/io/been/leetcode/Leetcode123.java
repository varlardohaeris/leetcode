package io.been.leetcode;

public class Leetcode123 {
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;
        for (int price : prices) {
            if (firstBuy < -price) {
                firstBuy = -price;
            }
            if (firstSell < firstBuy + price) {
                firstSell = firstBuy + price;
            }
            if (secondBuy < firstSell - price) {
                secondBuy = firstSell - price;
            }
            if (secondSell < secondBuy + price) {
                secondSell = secondBuy + price;
            }

        }
        return secondSell;
    }
}
