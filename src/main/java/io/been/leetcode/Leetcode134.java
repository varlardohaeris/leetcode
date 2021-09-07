package io.been.leetcode;

public class Leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remain = 0;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            remain += gas[i] - cost[i];
            if (remain < 0) {
                start = i + 1;
                remain = 0;
            }
            sum += gas[i] - cost[i];
        }
        if (sum < 0) {
            return -1;
        }
        return start;
    }
}
