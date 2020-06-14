package vip.wulang.leetcode.problem8;

public class Solution {
    public boolean isPalindromeOld(int x) {
        String s = x + "";

        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int newX = 0;
        int xx = x;
        while (xx >= 10) {
            newX = newX * 10 + xx % 10;
            xx /= 10;
        }
        newX = newX * 10 + xx % 10;
        return newX == x;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(121));
    }
}