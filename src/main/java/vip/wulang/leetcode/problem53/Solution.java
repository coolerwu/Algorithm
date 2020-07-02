package vip.wulang.leetcode.problem53;

public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            dp[i] = Math.max(num, dp[i - 1] + num);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[] {
                -2,1,-3,4,-1,2,1,-5,4
        }));
    }
}