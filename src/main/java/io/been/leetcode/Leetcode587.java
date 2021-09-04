package io.been.leetcode;

import java.util.*;

public class Leetcode587 {
    public int[][] outerTrees(int[][] trees) {
        Arrays.sort(trees, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < trees.length; i++) {
            while (stack.size() >= 2 && orientation(stack.get(stack.size() - 2),
                    stack.peek(), trees[i]) > 0) {
                stack.pop();
            }
            stack.push(trees[i]);
        }
        stack.pop();
        for (int i = trees.length - 1; i >= 0; i--) {
            while (stack.size() >= 2 && orientation(stack.get(stack.size() - 2),
                    stack.peek(), trees[i]) > 0) {
                stack.pop();
            }
            stack.push(trees[i]);
        }
        List<int[]> list = new ArrayList<>();
        list.addAll(new HashSet<>(stack));
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - p[0]) - (q[0] - p[0]) * (r[1] - p[1]);
    }
}
