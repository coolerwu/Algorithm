package vip.wulang.leetcode.problem70;

import java.util.HashMap;

public class Solution {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        return f(n, cache);
    }

    private int f(int n, HashMap<Integer, Integer> cache) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        Integer i = cache.get(n);
        if (i != null) {
            return i;
        }
        i = f(n - 1, cache) + f(n - 2, cache);
        cache.put(n, i);
        return i;
    }
}
