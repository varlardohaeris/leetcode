package io.been.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int l, int r, String cur) {
        if (l < 0 || r < 0 || l > r) return;
        if (l == 0 && r == 0) res.add(cur);
        dfs(l - 1, r, cur + "(");
        dfs(l, r - 1, cur + ")");
    }

}
