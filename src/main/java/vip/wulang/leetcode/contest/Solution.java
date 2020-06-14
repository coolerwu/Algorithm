package vip.wulang.leetcode.contest;

import java.util.*;

public class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        TreeMap<Integer, Info> map = new TreeMap<>();

        for (int value : arr) {
            final Info info = map.getOrDefault(value, new Info(0, value));
            info.time++;
            map.put(value, info);
        }

        List<Info> l = new ArrayList<>(map.values());
        Collections.sort(l);
        int size = l.size();
        for (Info info : l) {
            if (k == 0) {
                break;
            }
            while (info.time != 0 && k != 0) {
                info.time--;
                k--;
            }
            if (info.time == 0) {
                size--;
            }
        }

        return size;
    }

    private static class Info implements Comparable<Info> {
        public int time;
        public int index;

        public Info(int time, int index) {
            this.time = time;
            this.index = index;
        }

        @Override
        public int compareTo(Info o) {
            return time - o.time;
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().findLeastNumOfUniqueInts(new int[]{2,4,1,8,3,5,1,3}, 3));
    }
}
