package io.been.nc;

import java.util.Arrays;

public class NC671 {
    public int mindays(int n, int[] DEF) {
        Arrays.sort(DEF);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (res >= DEF[i]) {
                res++;
            } else {
                res = DEF[i];
            }
        }
        return res;
    }
}
