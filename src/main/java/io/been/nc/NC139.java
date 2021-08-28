package io.been.nc;

public class NC139 {
    public int lastRemaining(int n, int m) {
        if (n <= 0) return -1;
        if (n == 1) return 0;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }
}
