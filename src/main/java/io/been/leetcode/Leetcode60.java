package io.been.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode60 {
    public String getPermutation(int n, int k) {
        int[] f = new int[n];
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] * i;
        }
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            num.add(i);
        }
        k--;
        StringBuilder res = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int idx = k / f[i];
            res.append(num.get(idx));
            num.remove(idx);
            k %= f[i];
        }
        return res.toString();
    }
}
