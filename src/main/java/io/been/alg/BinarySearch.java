package io.been.alg;

public class BinarySearch {
    public static int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int idx = binarySearch(nums, 1);
        System.out.println(idx);
        idx = binarySearch(nums, 2);
        System.out.println(idx);
        idx = binarySearch(nums, 3);
        System.out.println(idx);
        idx = binarySearch(nums, 4);
        System.out.println(idx);
        idx = binarySearch(nums, 5);
        System.out.println(idx);
    }
}
