package vip.wulang.leetcode.problem5440;

public class Solution {
    public int xorOperation(int n, int start) {
        int xor = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                xor = start + 2 * i;
                continue;
            }
            xor ^= (start + 2 * i);
        }
        return xor;
    }
}
