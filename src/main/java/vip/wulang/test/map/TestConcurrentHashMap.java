package vip.wulang.test.map;

import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(i, i);
        }
    }
}
