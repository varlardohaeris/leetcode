package io.been.nc;

public class NC57 {
    public int reverse(int x) {
        int res = 0;
        while (x !=0) {
             if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                 return 0;
             }
             int num = x % 10;
             x /= 10;
             res = res * 10 + num;
        }
        return res;
    }
}
