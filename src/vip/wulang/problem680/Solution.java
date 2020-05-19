package vip.wulang.problem680;

public class Solution {
    public boolean validPalindrome(String s) {
        int len = s.length();
        int l = 0, r = len - 1;
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
                continue;
            }

            return isValid(s, l, r - 1) || isValid(s, l + 1, r);
        }
        return true;
    }

    private boolean isValid(String s, int start, int end) {
        int l = start, r = end;
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
                continue;
            }
            return false;
        }
        return true;
    }
}
