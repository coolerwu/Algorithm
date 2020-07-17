package vip.wulang.leetcode.problem5452;

import java.util.Arrays;

public class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return false;
        }

        Arrays.sort(arr);

        int div = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (i == 1) {
                div = arr[i] - arr[i - 1];
            } else if (div != arr[i] - arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
