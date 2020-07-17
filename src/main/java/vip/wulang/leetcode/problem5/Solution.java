package vip.wulang.leetcode.problem5;

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        char[] chars = s.toCharArray();

        boolean[][] dp = new boolean[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int start = 0;
        for (int i = 1; i < chars.length; i++) {
            for (int j = 0; j < i; j++) {
                if (chars[j] == chars[i]) {
                    if (j + 1 == i) {
                        start = maxLen > i - j + 1 ? start : j;
                        maxLen = maxLen > i - j + 1 ? maxLen : i - j + 1;
                        dp[i][j] = true;
                    } else if (dp[i - 1][j + 1]) {
                        start = maxLen > i - j + 1 ? start : j;
                        maxLen = maxLen > i - j + 1 ? maxLen : i - j + 1;
                        dp[i][j] = true;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("babad"));
        System.out.println(new Solution().longestPalindrome("cbbd"));
    }
}
