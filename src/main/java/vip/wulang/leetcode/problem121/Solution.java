package vip.wulang.leetcode.problem121;

public class Solution {
    /**
     * 前面的最小值，减去当前值的绝对值就是此时卖出的最大化利益。
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= min) {
                max = Math.max(prices[i] - min, max);
            } else {
                min = prices[i];
            }
        }
        return max;
    }
}
