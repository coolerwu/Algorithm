package vip.wulang.leetcode.problem14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String str = strs[0];
        int min = str.length();
        int common = min;
        for (int i = 1; i < strs.length; i++) {
            min = Math.min(min, strs[i].length());
            int commonL = 0;
            for (int j = 0; j < min; j++) {
                if (str.charAt(j) == strs[i].charAt(j)) {
                    commonL++;
                } else {
                    break;
                }
            }
            common = Math.min(common, commonL);
        }
        return str.substring(0, common);
    }
}
