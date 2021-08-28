package io.been.leetcode;

import java.util.List;
import java.util.TreeSet;

public class Leetcode632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        TreeSet<Elem> candidate = new TreeSet<Elem>((o1, o2)
                -> Integer.compare(o1.val, o2.val) == 0
                ? Integer.compare(o1.list, o2.list)
                : Integer.compare(o1.val, o2.val)
        );

        int n = nums.size();
        for (int i = 0; i < n; i++) {
            Elem e = new Elem(i, 0, nums.get(i).get(0));
            candidate.add(e);
        }

        int range = Integer.MAX_VALUE;
        int[] res = new int[2];
        while (candidate.size() == n) {
            int max = candidate.last().val;
            int min = candidate.first().val;
            if (max - min < range) {
                range = max - min;
                res[0] = min;
                res[1] = max;
            }
            Elem f = candidate.pollFirst();
            if (f.idx + 1 < nums.get(f.list).size()) {
                Elem next = new Elem(f.list, f.idx + 1,
                        nums.get(f.list).get(f.idx + 1));
                candidate.add(next);
            }
        }
        return res;
    }

    class Elem {
        int list;
        int idx;
        int val;

        public Elem(int list, int idx, int val) {
            this.list = list;
            this.idx = idx;
            this.val = val;
        }
    }
}
