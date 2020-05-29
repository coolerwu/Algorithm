package vip.wulang.leetcode.problem198;

public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        sum[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            sum[i] = Math.max(sum[i - 1], sum[i - 2] + nums[i]);
            sum[i - 1] = Math.max(sum[i - 1], sum[i - 2]);
        }
        return sum[nums.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(solution.rob(new int[]{2, 1, 1, 2}));
    }
}
