package vip.wulang.test.aqs;

import vip.wulang.util.SleepHelper;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class CustomAQS01 extends CustomAQS {

    public ConditionObject condition() {
        return new ConditionObject();
    }

    @Override
    protected boolean isHeldExclusively() {
        return Thread.currentThread() == getExclusiveOwnerThread();
    }

    public static void main(String[] args) {
        CustomAQS01 aqs = new CustomAQS01();
        ConditionObject condition = aqs.condition();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                aqs.acquire(1);
                if (finalI == 9) {
                    System.out.println("释放了" + Thread.currentThread().getName());
                    SleepHelper.sleepSecond(2);
                    condition.signalAll();
                    aqs.release(1);
                    return;
                } else {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName());
                aqs.release(1);
            }, "custom-" + i).start();
        }
    }
}
