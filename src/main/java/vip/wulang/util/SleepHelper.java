package vip.wulang.util;

import java.util.concurrent.TimeUnit;

public class SleepHelper {
    private SleepHelper() {
    }

    public static void sleepSecond(long timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
