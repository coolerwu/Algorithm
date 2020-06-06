package vip.wulang.test.map;

import java.util.LinkedHashMap;

public class TestLinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Object> map = new LinkedHashMap<>();
        for (int i = 0; i < 100000; i++) {
            map.put(i, i);
        }
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
