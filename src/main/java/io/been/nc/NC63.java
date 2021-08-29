package io.been.nc;

import java.util.HashSet;
import java.util.Set;

public class NC63 {
    public boolean IsContinuous(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        int max = -1;
        int min = 15;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) continue;
            max = Math.max(max, numbers[i]);
            min = Math.min(min, numbers[i]);
            if (set.contains(numbers[i])) return false;
            set.add(numbers[i]);
        }
        return max - min < 5;
    }
}
