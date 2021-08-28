package io.been.leetcode;

import java.util.Stack;

public class Leetcode84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int length = heights.length;
        int ans = 0;
        int num = 0;
        for (int i = 0; i <= length; i++) {
            num = (i == length) ? 0 : heights[i];
            if (stack.isEmpty() || num >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int temp = stack.pop();
                int len = 0;
                if (stack.isEmpty()) len = i;
                else {
                    len = i - 1 - stack.peek();
                }
                ans = Math.max(ans, heights[temp] * len);
                i--;
            }
        }
        return ans;
    }
}
