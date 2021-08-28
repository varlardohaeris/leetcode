package io.been.leetcode;

import java.util.Arrays;

public class Leetcode1300 {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        long[] preSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }

        int start = 0;
        int end = n - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            long sum = preSum[mid + 1] + arr[mid] * (n - 1 - mid);
            if (sum < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        long pre = preSum[start];
        int count = n - start - 1;
        if ((long) arr[0] * n > target) {
            start = 0;
            end = arr[0];
            count += 1;
        } else {
            pre = preSum[start + 1];
            start = arr[start];
            end = arr[end];
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            long sum = pre + mid * count;
            if (sum < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        long startSum = pre + start * count;
        long endSum = pre + end * count;

        if (Math.abs(startSum - target) <= Math.abs(endSum - target)) {
            return start;
        } else {
            return end;
        }
    }
}
