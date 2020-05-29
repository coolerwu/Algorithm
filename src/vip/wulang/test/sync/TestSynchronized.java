package vip.wulang.test.sync;

/**
 * 用来测试synchronized是否保证里面的变量原子性
 */
public class TestSynchronized {
    private static boolean init = false;

    public static synchronized void init() {
        if (!init) {
            System.out.println("before init is false");
        }
        init = true;
    }

    public static void main(String[] args) {
        for (int i = 100; i >= 0; i--) {
            new Thread(TestSynchronized::init).start();
        }
    }
}
