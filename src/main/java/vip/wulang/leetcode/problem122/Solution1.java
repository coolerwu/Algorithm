package vip.wulang.leetcode.problem122;

public class Solution1 {
    /**
     * 思路是：
     *  1、如果当前值小于买入节点，则更新当前节点为买入节点，并把上一次累加的tmpSum放入sum中。
     *  2、如果开始节点到当前节点相差值大于前一个节点到开始节点的最大值，则重新记录tmpSum并进行下一次遍历。
     *  3、如果开始节点到当前节点相差值小于等于前一个节点到开始节点的最大值，则把上一次累加的tmpSum放入sum中，以当前节点为索引买入节点。
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int sum = 0;
        int tmpSum = 0;
        int start = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= prices[start]) {
                start = i;
                sum += tmpSum;
                tmpSum = 0;
                continue;
            }
            if (tmpSum >= prices[i] - prices[start]) {
                sum += tmpSum;
                tmpSum = 0;
                start = i;
            } else {
                tmpSum = prices[i] - prices[start];
            }
        }

        sum += tmpSum;
        return sum;
    }



    public static void main(String[] args) {
        System.out.println(new Solution1().maxProfit(new int[]{
                7,1,5,3,6,4
//                1,2,3,4,5
        }));
    }
}