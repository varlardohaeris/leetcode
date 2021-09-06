package io.been.leetcode;

class VersionControl {
    public boolean isBadVersion(int version) {
        return true;
    }
}

public class Leetcode278 extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
