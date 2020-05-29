package vip.wulang.test.clh;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 实现了CLH。通过忙等待实现的。
 *
 * @version 1.0
 */
public class TestCLH {
    private static class CLHNode {
        private volatile boolean locked = true;
    }

    private static final AtomicReference<CLHNode> tail = new AtomicReference<>();
    private static final ThreadLocal<CLHNode> tl = new ThreadLocal<>();

    public static void lock() {
        CLHNode clhNode = tl.get();
        if (clhNode == null) {
            clhNode = new CLHNode();
            tl.set(clhNode);
        }

        CLHNode pre = tail.getAndSet(clhNode);
        if (pre != null) {
            while (pre.locked) {

            }
        }
    }

    public static void unlock() {
        CLHNode clhNode = tl.get();
        tl.remove();
        if (clhNode != null) {
            clhNode.locked = false;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                lock();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("locking");
                unlock();
            }).start();
        }
    }
}
