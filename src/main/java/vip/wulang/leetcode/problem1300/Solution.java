package vip.wulang.leetcode.problem1300;

import java.util.Arrays;

public class Solution {
    public int findBestValue(int[] arr, int target) {
        // 1、排序，依次递增
        // 2、用target/arr.length求出平均值
        // 3、如果平均值小于等于当前arr[i]，则返回这个平均值。
        // 4、但是arr.length-1，且target-a当前arr[i]。
        Arrays.sort(arr);
        int sum = 0;
        int average;
        for (int i = 0; i < arr.length; i++) {
            average = (target - sum) / (arr.length - i);
            if (average <= arr[i]) {
                double div = (target - sum) / ((arr.length - i) * 1.0);
                if (div > average + 0.5) {
                    return average + 1;
                } else {
                    return average;
                }
            }
            sum += arr[i];
        }
        return arr[arr.length - 1];
    }
}