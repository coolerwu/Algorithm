package vip.wulang.problem152;

class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int sum = 1;
        int max = nums[0];
        for (int num : nums) {
            sum *= num;
            if (max < sum) max = sum;
            if (num == 0) sum = 1;
        }
        sum = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum *= nums[i];
            if (max < sum) max = sum;
            if (nums[i] == 0) sum = 1;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(new Solution().maxProduct(new int[]{-2, 0, -1}));
    }
}