package io.been;

public class Leetcode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if ((m + n) % 2 == 1) {
            return findKth((m + n) / 2 + 1, nums1, 0, nums2, 0);
        } else {
            return (findKth((m + n) / 2, nums1, 0, nums2, 0)
                    + findKth((m + n) / 2 + 1, nums1, 0, nums2, 0)) / 2;
        }
    }

    private double findKth(int k, int[] nums1, int idx1, int[] nums2, int idx2) {
        int l1 = nums1.length - idx1;
        int l2 = nums2.length - idx2;
        if (l1 > l2) {
            return findKth(k, nums2, idx2, nums1, idx1);
        }

        if (l1 == 0) {
            return nums2[idx2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[idx1], nums2[idx2]);
        }

        int cut1 = Math.min(k / 2, l1);
        int cut2 = k - cut1;
        if (nums1[idx1 + cut1 - 1] > nums2[idx2 + cut2 - 1]) {
            return findKth(k - cut2, nums1, idx1, nums2, idx2 + cut2);
        } else {
            return findKth(k - cut1, nums1, idx1 + cut1, nums2, idx2);
        }
    }
}
