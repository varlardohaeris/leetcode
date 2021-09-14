package io.been.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!s.isEmpty() && nums[s.peek()] < num) {
                res[s.peek()] = num;
                s.pop();
            }
            if (i < n) {
                s.push(i);
            }
        }
        return res;
    }
}
