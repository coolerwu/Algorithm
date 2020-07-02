package vip.wulang.leetcode.problem122;

public class Solution {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1) {
            return 0;
        }

        return process(prices, 0);
    }

    // index是买点
    private int process(int[] prices, int index) {
        int len = prices.length;
        if (index >= len - 1) {
            return 0;
        }

        if (prices[index] > prices[index + 1]) {
            return process(prices, index + 1);
        }

        int sum = 0;
        int max = 0;
        for (int i = index + 1; i < len; i++) {
            if (prices[i] < prices[index] && i - 1 != index) {
                sum = prices[i - 1] - prices[index];
            } else {
                sum = prices[i] - prices[index];
            }
            int a = process(prices, i + 1);
            max = Math.max(max, sum + a);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{
//                7,1,5,3,6,4
                1,2,3,4,5
        }));
    }
}