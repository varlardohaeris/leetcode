package io.been.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode638 {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shopping(price, special, needs, 0);
    }

    private int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int index) {
        if (index == special.size()) {
            return purchaseWithOriginalPrice(price, needs);
        }
        List<Integer> clone = new ArrayList<>(needs);
        int i;
        for (i = 0; i < special.get(index).size() - 1; i++) {
            int remain = needs.get(i) - special.get(index).get(i);
            if (remain < 0) {
                break;
            } else {
                clone.set(i, remain);
            }
        }

        if (i == special.get(index).size() - 1) {
            return Math.min(special.get(index).get(i) + shopping(price, special, clone, index),
                    shopping(price, special, needs, index + 1));
        } else {
            return shopping(price, special, needs, index + 1);
        }
    }

    private int purchaseWithOriginalPrice(List<Integer> price, List<Integer> needs) {
        int sum = 0;
        for (int i = 0; i < needs.size(); i++) {
            sum += needs.get(i) * price.get(i);
        }
        return sum;
    }

}
