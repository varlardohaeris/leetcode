package io.been.leetcode;

import java.util.Locale;

public class Leetcode468 {
    public String validIPAddress(String IP) {
        String ip = IP.toLowerCase();
        String[] ip4 = ip.split("\\.", -1);
        if (ip4.length == 4) {
            return check4(ip4);
        }
        String[] ip6 = ip.split(":", -1);

        if (ip6.length == 8) {
            return check6(ip6);
        }
        return "Neither";
    }

    private String check4(String[] ip4) {
        for (String s : ip4) {
            int n = s.length();
            if (n == 0 || n > 3) {
                return "Neither";
            }
            for (int i = 0; i < n; i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    return "Neither";
                }
            }
            int num = Integer.parseInt(s);
            if (num < 0 || num > 255) {
                return "Neither";
            }
            if (String.valueOf(num).length() < n) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    private String check6(String[] ip6) {
        for (String s : ip6) {
            int n = s.length();
            if (n == 0 || n > 4) {
                return "Neither";
            }
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f')) {
                    continue;
                }
                return "Neither";
            }
        }
        return "IPv6";
    }
}
