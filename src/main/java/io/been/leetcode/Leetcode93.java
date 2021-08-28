package io.been.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode93 {
    private List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        search(s, 1, "");
        return res;
    }

    private void search(String s, int n, String ipAddr) {
        if (n == 5 && s.length() == 0) {
            res.add(ipAddr.substring(0, ipAddr.length() - 1));
            return;
        }
        if (n >= 5) {
            return;
        }
        int remain = 5 - n;
        if (s.length() < remain || s.length() > 3 * remain) {
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (s.length() < i) {
                return;
            }
            String part = s.substring(0, i);
            int num = Integer.parseInt(part);
            if (part.length() != String.valueOf(num).length()) {
                return;
            }
            if (num > 255) {
                return;
            }
            search(s.substring(i), n + 1, ipAddr + part + ".");
        }
    }
}
