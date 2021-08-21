package io.been;

import java.util.Stack;

public class Leetcode962 {
    public int maxWidthRamp(int[] nums) {
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < len; i++) {
            if (nums[stack.peek()] > nums[i]) stack.push(i);
        }
        int start = 0;
        int width = 0;
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                start = stack.pop();
                width = Math.max(width, i - start);
            }
        }
        return width;
    }
}
