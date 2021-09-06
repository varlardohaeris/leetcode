package io.been.leetcode;

public class Leetcode168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        if (columnNumber == 0) {
            return "";
        }
        columnNumber--;
        return convertToTitle(columnNumber / 26) + (char) (columnNumber % 26 + 'A');
    }
}
