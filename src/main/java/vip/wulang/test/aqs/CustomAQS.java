package vip.wulang.test.aqs;

import vip.wulang.util.SleepHelper;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class CustomAQS extends AbstractQueuedSynchronizer {
    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }



    @Override
    protected boolean tryAcquire(int arg) {
        if (Thread.currentThread() == getExclusiveOwnerThread()) {
            return true;
        }
        int state = getState();
        if (state == 0 && compareAndSetState(state, 1)) {
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int arg) {
        if (Thread.currentThread() != getExclusiveOwnerThread()) {
            return false;
        }
        if (compareAndSetState(getState(), 0)) {
            setExclusiveOwnerThread(null);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CustomAQS aqs = new CustomAQS();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SleepHelper.sleepSecond(1);
                aqs.acquire(1);
                SleepHelper.sleepSecond(1);
                System.out.println(Thread.currentThread().getName());
                aqs.release(1);
            }, "custom-" + i).start();
        }
    }
}
