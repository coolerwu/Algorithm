package vip.wulang.test.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestFIFO extends LinkedHashMap<Integer, Object> {
    private int max;

    public TestFIFO(int max) {
        this.max = max;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Object> eldest) {
        return size() > max;
    }

    public static void main(String[] args) {
        TestFIFO map = new TestFIFO(10);
        for (int i = 0; i < 100000; i++) {
            map.put(i, i);
        }
        map.forEach((k, v) -> System.out.println(k + ":" + v));
        for (int i = 100000; i < 100010; i++) {
            map.put(i, i);
        }
        System.out.println("FIFO");
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
