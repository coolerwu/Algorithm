package vip.wulang.test.map;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * -Xms5m -Xmn5m
 * 结果：game over40674
 */
public class TestWeakHashMap {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field queue = WeakHashMap.class.getDeclaredField("queue");
        queue.setAccessible(true);
        Map<Integer, Object> map = new WeakHashMap<>();
        @SuppressWarnings("rawtypes")
        ReferenceQueue q = (ReferenceQueue) queue.get(map);
        int i = 0;
        while (true) {
            map.put(i, i);
            i++;

            if (q.poll() != null) {
                System.out.println("game over " + map.size());
                return;
            }
        }
    }
}
