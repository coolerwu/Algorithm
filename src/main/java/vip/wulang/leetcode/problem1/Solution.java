package vip.wulang.leetcode.problem1;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] index = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(target - nums[i], i);
            } else {
                index[0] = map.get(nums[i]);
                index[1] = i;
                return index;
            }
        }
        return index;
    }
}
