package io.been.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode17 {
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] board = new String[]{
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        res.add("");
        for (char ch : digits.toCharArray()) {
            int index = ch - '0' - 1;
            List<String> tmp = new ArrayList<>();
            for (String s : res) {
                for (char c : board[index].toCharArray()) {
                    tmp.add(s + c);
                }
            }
            res = tmp;
        }
        return res;
    }
}
