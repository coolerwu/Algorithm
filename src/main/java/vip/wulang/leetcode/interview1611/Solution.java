package vip.wulang.leetcode.interview1611;

public class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == 0 || (shorter == longer)) {
            return new int[]{longer * k};
        }
        int[] sums = new int[k + 1];
        for (int i = 0; i < k + 1; i++) {
            sums[i] = shorter * (k - i) + longer * i;
        }
        return sums;
    }
}
