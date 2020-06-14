package vip.wulang.leetcode.problem15;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSumOld(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            HashMap<Integer, List<Integer>> map = new HashMap<>();

            for (int i1 = i + 1; i1 < nums.length; i1++) {

                if (map.get(nums[i1]) != null) {
                    final List<Integer> l = map.get(nums[i1]);
                    l.add(nums[i1]);
                    Collections.sort(l);

                    String str = l.get(0) + "" + l.get(1) + "" + l.get(2);

                    map.put(nums[i1], null);
                    if (set.contains(str)) {
                        continue;
                    }

                    set.add(str);
                    result.add(l);
                } else {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[i1]);
                    map.put(-nums[i] - nums[i1], l);
                }

            }
        }

        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < nums.length - 1; i++) {

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{1, 2, -2, -1}));
    }
}
