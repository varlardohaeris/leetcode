package io.been.leetcode;

public class Leetcode744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int size = letters.length;
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low < size ? letters[low] : letters[0];
    }
}
