package vip.wulang.leetcode.jianOffer;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Solution03 {


    public int findRepeatNumber(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] == i) {
                continue;
            }


            while (nums[i] != i) {
                // !=i
                // before swap, check
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }

                // swap
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution03().findRepeatNumber(new int[] {2, 3, 1, 0, 2, 5, 3}));

        Date end = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(end);
        calendar.add(Calendar.MONTH, -3);
        Date start = calendar.getTime();

        

        System.out.println(end);
        System.out.println(start);
    }
}
