package io.been.offer;

public class Offer3 {
    public int findRepeatNumber(int[] nums) {
        int[] mem = new int[nums.length];
        for (int num : nums) {
            mem[num]++;
            if (mem[num] > 1) {
                return num;
            }
        }
        return -1;
    }
}
