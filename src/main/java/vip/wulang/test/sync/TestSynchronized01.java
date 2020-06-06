package vip.wulang.test.sync;

import static vip.wulang.util.SleepHelper.*;

/**
 * synchronized修饰方法，加的是实例，synchronized(this) {}
 */
public class TestSynchronized01 {

    public synchronized void hi() {
        System.out.println(Thread.currentThread());
        sleepSecond(5);
        System.out.println("hi");
    }

    public synchronized void hello() {
        System.out.println(Thread.currentThread());
        sleepSecond(3);
        System.out.println("hello");
    }

    public static void main(String[] args) {
        TestSynchronized01 test = new TestSynchronized01();
        new Thread(test::hi, "hi-t").start();
        new Thread(test::hello, "hello-t").start();
        test.hello();
    }
}
