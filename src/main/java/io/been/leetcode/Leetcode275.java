package io.been.leetcode;

public class Leetcode275 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0) {
            return 0;
        }
        int start = 0;
        int end = n - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int h = n - mid;
            if (citations[mid] < h) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (citations[start] >= n - start) {
            return n - start;
        }
        if (citations[end] < n - end) {
            return 0;
        }
        return n - end;
    }
}
