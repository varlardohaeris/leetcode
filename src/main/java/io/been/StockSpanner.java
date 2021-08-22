package io.been;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanner {
    private Stack<Integer> index;
    private List<Integer> prices;

    public StockSpanner() {
        index = new Stack<>();
        prices = new ArrayList<>();
    }

    public int next(int price) {
        prices.add(price);
        int cur = prices.size() - 1;
        while (!index.isEmpty() && prices.get(index.peek()) <= price) {
            index.pop();
        }
        int start = index.isEmpty() ? -1 : index.peek();
        index.push(cur);
        return cur - start;
    }
}
