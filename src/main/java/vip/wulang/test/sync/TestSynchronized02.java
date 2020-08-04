package vip.wulang.test.sync;

public class TestSynchronized02 {
    private final Object empty = new Object();

    public void lock() throws InterruptedException {
        synchronized (TestSynchronized02.class) {
            empty.wait();
        }
    }

    public static void main(String[] args) {
        
    }
}
