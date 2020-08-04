package vip.wulang.leetcode.problem498;

import java.util.Arrays;

public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return null;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[] sim = new int[m * n];
        int tag = 0;

        int index = 0;
        while (index < n + m - 1) {
            if (index % 2 != 0) {
                int x1 = index < n ? index : n - 1;
                int y1 = index - x1;
                while (x1 >= 0 && y1 < m) {
                    sim[tag] = matrix[y1][x1];
                    tag++;
                    x1--;
                    y1++;
                }
            } else {
                int x1 = index < m ? index : m - 1;
                int y1 = index - x1;
                while (x1 >= 0 && y1 < n) {
                    sim[tag] = matrix[x1][y1];
                    tag++;
                    x1--;
                    y1++;
                }
            }
            index++;
        }
        return sim;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findDiagonalOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        })));
    }
}