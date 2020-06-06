package vip.wulang.test.map;

import java.util.HashMap;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap<Integer, Object> map = new HashMap<>();
        for (int i = 0; i < 18; i++) {
            map.put(i, i);
        }
    }
}
