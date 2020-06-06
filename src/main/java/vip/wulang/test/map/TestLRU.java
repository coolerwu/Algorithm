package vip.wulang.test.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestLRU extends LinkedHashMap<Integer, Object> {
    private int max;

    public TestLRU(int max) {
        super(16, 0.75f, true);
        this.max = max;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Object> eldest) {
        return size() > max;
    }

    public static void main(String[] args) {
        TestLRU map = new TestLRU(10);
        for (int i = 0; i < 100000; i++) {
            map.put(i, i);
        }
        map.forEach((k, v) -> System.out.println(k + ":" + v));
        for (int i = 99990; i < 99995; i++) {
            map.get(i);
        }
        for (int i = 100000; i < 100005; i++) {
            map.put(i, i);
        }
        System.out.println("LRU");
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
