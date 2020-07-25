package vip.wulang.util;

public class StringToArray {
    private StringToArray() {
    }

    public static int[][] twoArray(String str) {
        for (String s : str.split(",")) {
            s = s.trim().replaceAll("\\[", "");
            s = s.trim().replaceAll("\\]", "");
            for (String s1 : s.split(",")) {
                s1 = s1.trim();

            }
        }
        return null;
    }
}
