package vip.wulang.leetcode.problem5441;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public String[] getFolderNamesOld(String[] names) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (set.contains(name)) {
                final String change = change(name);
                if (!name.equals(change)) {
                    int j = 1;
                    while (set.contains(name + "(" + j + ")")) {
                        j++;
                    }
                    names[i] = name + "(" + j + ")";
                    set.add(names[i]);
                    continue;
                }
                int j = 1;
                while (set.contains(change + "(" + j + ")")) {
                    j++;
                }
                names[i] = change + "(" + j + ")";
            }
            set.add(names[i]);
        }
        return names;
    }

    private String change(String str) {
        final int indexPre = str.lastIndexOf("(");
        if (indexPre >= 0) {
            str = str.substring(0, indexPre);
        }
        return str;
    }

    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            Integer count = map.get(name);
            if (count != null) {
                while (map.get(name + "(" + count + ")") != null) {
                    count++;
                }
                names[i] = name + "(" + count + ")";
                map.put(name + "(" + count + ")", 1);
            } else {
                count = 1;
            }
            map.put(name, count);
        }
        return names;
    }

    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.getFolderNames(new String[]{
//                "pes","fifa","gta","pes(2019)"
//                "gta","gta(1)","gta","avalon"
                "onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"
//                "wano","wano","wano","wano"
//                "kaido","kaido(1)","kaido","kaido(1)"
//                "kaido","kaido(1)","kaido","kaido(1)","kaido(2)"
        })));
    }
}
