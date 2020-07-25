package vip.wulang.leetcode.jianOffer;

public class Solution04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int col = matrix[0].length - 1;
        int row = 0;
        while (row < matrix.length && col >= 0) {
            int num = matrix[row][col];
            if (num == target) {
                return true;
            } else if (num < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution04().findNumberIn2DArray(
                new int[][]{
                        {1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}
                },5
        ));
    }
}
