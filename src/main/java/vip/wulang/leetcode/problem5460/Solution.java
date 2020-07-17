package vip.wulang.leetcode.problem5460;

public class Solution {
    public int numIdenticalPairs(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int tp = 0;
        for (int i = 1; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[i] == nums[j]) {
                    tp++;
                }

            }
        }
        return tp;
    }
}