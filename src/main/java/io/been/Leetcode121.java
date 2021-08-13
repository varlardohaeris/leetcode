package io.been;

public class Leetcode121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int cur = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[cur]) {
                cur = i;
            }
            res = Math.max(res, prices[i] - prices[cur]);
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
