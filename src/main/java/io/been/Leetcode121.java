package io.been;

public class Leetcode121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            res = Math.max(res, price - minPrice);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] prices = {7, 1, 5, 3, 6};
        int[] prices = {7, 6, 4, 3, 1};
        int res = new Leetcode121().maxProfit(prices);
        System.out.println(res);
    }
}
