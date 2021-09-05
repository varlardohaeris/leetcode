package io.been.leetcode;

import java.util.Stack;
import java.util.TreeMap;

public class Leetcode726 {
    public String countOfAtoms(String formula) {
        Stack<TreeMap<String, Integer>> stack = new Stack<>();
        TreeMap<String, Integer> curMap = new TreeMap<>();
        int len = formula.length();
        for (int i = 0; i < len; ) {
            char c = formula.charAt(i);
            if (c == '(') {
                stack.push(curMap);
                curMap = new TreeMap<>();
                i++;
            } else if (c == ')') {
                TreeMap<String, Integer> temp = curMap;
                curMap = stack.pop();
                i++;
                int istart = i;
                int quantity = 1;
                while (i < len && Character.isDigit(formula.charAt(i))) i++;
                if (istart < i) {
                    quantity = Integer.parseInt(formula.substring(istart, i));
                }
                for (String name : temp.keySet()) {
                    curMap.put(name, curMap.getOrDefault(name, 0) + temp.get(name) * quantity);
                }
            } else {
                int istart = i;
                i++;
                while (i < len && Character.isLowerCase(formula.charAt(i))) i++;
                String name = formula.substring(istart, i);
                istart = i;
                int quantity = 1;
                while (i < len && Character.isDigit(formula.charAt(i))) i++;
                if (istart < i) {
                    quantity = Integer.parseInt(formula.substring(istart, i));
                }
                curMap.put(name, curMap.getOrDefault(name, 0) + quantity);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String name : curMap.keySet()) {
            int quantity = curMap.get(name);
            builder.append(name);
            if (quantity > 1) {
                builder.append(quantity);
            }
        }
        return builder.toString();
    }
}
