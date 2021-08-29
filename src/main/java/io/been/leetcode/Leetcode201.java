package io.been.leetcode;

public class Leetcode201 {
    public int rangeBitwiseAnd(int left, int right) {
        int msb1 = msb(left);
        int msb2 = msb(right);
        if (msb1 != msb2) return 0;
        int msb = msb1;
        int result = 0;
        while (msb >= 0) {
            int x = get_bit(left, msb);
            int y = get_bit(right, msb);
            if (x != y) {
                return result;
            } else if (x == 1) {
                result = set_bit(result, msb);
            }
            msb--;
        }
        return result;
    }

    private int get_bit(int m, int i) {
        return ((m >> i) & 1);
    }

    private int set_bit(int res, int i) {
        return (res | (1 << i));
    }

    private int msb(int m) {
        int count = 0;
        while (m > 0) {
            count++;
            m = (m >> 1);
        }
        return count - 1;
    }
}
