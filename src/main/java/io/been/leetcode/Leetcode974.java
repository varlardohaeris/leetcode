package io.been.leetcode;

/**
 * https://www.cnblogs.com/grandyang/p/14163228.html
 */
public class Leetcode974 {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        int[] cnt = new int[k];
        cnt[0] = 1;
        for (int num : nums) {
            sum = (sum + num % k + k) % k;
            res += cnt[sum];
            ++cnt[sum];
        }
        return res;
    }
}
