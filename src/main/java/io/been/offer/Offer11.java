package io.been.offer;

public class Offer11 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                return findMin(numbers, left, right);
            }
        }
        return numbers[left];
    }

    private int findMin(int[] numbers, int left, int right) {
        int res = numbers[left];
        for (int i = left; i <= right; i++) {
            res = Math.min(res, numbers[i]);
        }
        return res;
    }
}
