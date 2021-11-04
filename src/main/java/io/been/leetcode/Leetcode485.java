package io.been.leetcode;

public class Leetcode485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int cnt = 0;
        for (int num : nums) {
            cnt = num == 0 ? 0 : cnt + 1;
            res = Math.max(res, cnt);
        }
        return res;
    }
}
