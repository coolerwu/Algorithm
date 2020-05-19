package vip.wulang.problem169;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int majority = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer orDefault = map.getOrDefault(num, 0);
            orDefault++;
            if (orDefault >= majority) {
                return num;
            } else {
                map.put(num, orDefault);
            }
        }
        return 0;
    }
}
