package io.been.leetcode;

public class Leetcode45 {
    public int jump(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int i = 0;
        int cur = 0;
        while (cur < n - 1) {
            ans++;
            int pre = cur;
            for (; i <= pre; i++) {
                cur = Math.max(cur, i + nums[i]);
            }
            if (pre == cur) return -1;
        }
        return ans;
    }
}
