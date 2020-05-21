package vip.wulang.test.threadLocal;

public class TestThreadLocal {
    public static void main(String[] args) {
        ThreadLocal<Integer> tl1 = ThreadLocal.withInitial(() -> 500);
        ThreadLocal<Integer> tl2 = ThreadLocal.withInitial(() -> 500);
        tl1.set(100);
        System.out.println("tl1:" + tl1.get());
        tl1.remove();
        System.out.println("tl1:" + tl1.get());
        System.out.println("tl2:" + tl2.get());
    }
}
