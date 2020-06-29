package vip.wulang.leetcode.problem5442;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
    public int[] avoidFlood(int[] rains) {
        // key:n lake, value: isRaining
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rains.length; i++) {
            int rain = rains[i];
            if (rain == 0) {
                boolean hasRains = false;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    Integer val = entry.getValue();
                    if (val != null && val == 1) {
                        rains[i] = entry.getKey();
                        map.put(entry.getKey(), --val);
                        hasRains = true;
                        break;
                    }
                }
                if (!hasRains) {
                    rains[i] = 1;
                }
            } else {
                int val = map.getOrDefault(rain, 0);
                if (val == 1) {
                    return new int[0];
                }
                map.put(rain, ++val);
                rains[i] = -1;
            }
        }
        return rains;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new Solution().avoidFlood(
                                new int[]{
//                                        1,2,3,4
//                                        1,2,0,0,2,1
//                                        1,2,0,1,2
//                                        69,0,0,0,69
//                                        10,20,20
                                        1,2,0,2,3,0,1
                                }
                        )
                )
        );
    }
}
