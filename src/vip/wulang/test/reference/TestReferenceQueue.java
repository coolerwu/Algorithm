package vip.wulang.test.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 实验结果：
 *  1、-127～127
 */
public class TestReferenceQueue {
    public static void main(String[] args) {
        final ReferenceQueue<Integer> queue = new ReferenceQueue<>();
        final WeakReference<Integer> weakReference = new WeakReference<>(128, queue);

        //start一个线程进行监控
        new Thread(() -> {
            while (true) {
                Reference<? extends Integer> ref = queue.poll();
                if (ref != null) {
                    System.out.println("--- 虚引用对象被jvm回收了 ----" + ref.get());
                    System.exit(1);
                }
            }
        }).start();

        //初始化一个list，不停的添加数据，出发jvm gc
        List<Integer> list = new ArrayList<>();
        new Thread(() -> {
            while (true) {
                list.add(128);
                Integer integer = weakReference.get();
                if (integer == null) {
                    System.out.println("list is zero, has " + list.stream().filter(Objects::isNull).count());
                }
            }
        }).start();
    }
}
