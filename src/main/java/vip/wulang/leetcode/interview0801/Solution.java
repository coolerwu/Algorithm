package vip.wulang.leetcode.interview0801;

public class Solution {
    public int waysToStep(int n) {
        int[] f = new int[n + 1];

        if (n <= 3) {
            return n == 1 ? 1 : (n == 2 ? 2 : 4);
        }

        f[1] = 1;
        f[2] = 2;
        f[3] = 4;

        for (int i = 4; i <= n; i++) {
            f[i] = ((f[i - 1] + f[i - 2]) % 1000000007 + f[i - 3]) % 1000000007;
        }

        return f[n];
    }
}