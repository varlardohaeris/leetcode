package io.been.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class Leetcode12 {
    public String intToRoman(int num) {
        LinkedHashMap<Integer, String> table = new LinkedHashMap<>();
        table.put(1000, "M");
        table.put(900, "CM");
        table.put(500, "D");
        table.put(400, "CD");
        table.put(100, "C");
        table.put(90, "XC");
        table.put(50, "L");
        table.put(40, "XL");
        table.put(10, "X");
        table.put(9, "IX");
        table.put(5, "V");
        table.put(4, "IV");
        table.put(1, "I");
        StringBuilder builder = new StringBuilder();


        for (Map.Entry<Integer, String> entry : table.entrySet()) {
            int key = entry.getKey();
            String value = entry.getValue();
            while (num >= key) {
                num -= key;
                builder.append(value);
            }
        }
        return builder.toString();

    }
}
