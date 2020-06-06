package vip.wulang.leetcode.problem229;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        List<Integer> list = new ArrayList<>(2);
        if (nums.length == 1) {
            list.add(nums[0]);
            return list;
        } else if (nums.length == 2) {

        }

        int o1 = nums[0], o2 = nums[1];
        int c1 = 0, c2 = 0;
        for (int i = 2; i < nums.length; i++) {
            int num = nums[i];
            if (num == o1) c1++;
            else if (num == o2) o2++;
            else if (c1 == 0) {
                c1++;
                o1 = nums[i + 1];
            } else if (c2 == 0) {
                c2++;
                o2 = nums[i + 2];
            } else {
                c1--;
                c2--;
            }
        }

        c1 = c2 = 0;
        for (int num : nums) {
            if (num == o1) {
                c1++;
            } else if (num == o2) {
                c2++;
            }
        }
        if (c1 > nums.length / 3) {
            list.add(c1);
        }
        if (c2 > nums.length / 3) {
            list.add(c2);
        }
        return list;
    }
}
