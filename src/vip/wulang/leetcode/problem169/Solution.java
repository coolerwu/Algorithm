package vip.wulang.leetcode.problem169;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 执行用时：17 ms
     * 内存消耗：45.4 MB
     */
    public int majorityElement1(int[] nums) {
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

    /**
     * 执行用时 :2051 ms, 在所有 Java 提交中击败了5.01%的用户
     * 内存消耗 :43.2 MB, 在所有 Java 提交中击败了5.71%的用户
     */
    public int majorityElement2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int majority = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1;

        for (int i = 0; i < nums.length; i++) {
            int sum = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    sum++;
                }
                if (sum >= majority) {
                    return nums[i];
                }
            }
            if (sum >= majority) {
                return nums[i];
            }
        }

        return 0;
    }

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 1;
        int maj = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maj == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    maj = nums[i + 1];
                }
            }
        }
        return maj;
    }
}
