package io.been.leetcode;

import java.util.Stack;
// https://www.bilibili.com/video/BV1yx411j7yM?from=search&seid=13386732623032154325&spm_id_from=333.337.0.0
public class Leetcode581 {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int l = nums.length;
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                r = Math.max(r, stack.pop());
            }
            stack.push(i);
        }

        return r - l > 0 ? r - l + 1 : 0;
    }
}
