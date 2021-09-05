package io.been.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        int[] state = new int[maxChoosableInteger + 1];
        return canWin(state, desiredTotal, new HashMap<String, Boolean>());
    }

    private boolean canWin(int[] state, int total, Map<String, Boolean> map) {
        String key = Arrays.toString(state);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        for (int i = 1; i < state.length; i++) {
            if (state[i] == 0) {
                state[i] = 1;
                if (total - i <= 0 || !canWin(state, total - i, map)) {
                    map.put(key, true);
                    state[i] = 0;
                    return true;
                }
                state[i] = 0;
            }
        }
        map.put(key, false);
        return false;
    }
}
