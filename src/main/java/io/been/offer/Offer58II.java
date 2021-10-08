package io.been.offer;

public class Offer58II {
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        char[] chars = s.toCharArray();
        reverse(chars, 0, len - 1);
        reverse(chars, 0, len - n - 1);
        reverse(chars, len - n, len - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
