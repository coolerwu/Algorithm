package vip.wulang.test.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.util.concurrent.FastThreadLocalThread;

/**
 * @author CoolerWu
 * @version 1.0
 */
public class DemoMemory {
    public static void main(String[] args) {
        new FastThreadLocalThread(() -> {


            PooledByteBufAllocator allocator = PooledByteBufAllocator.DEFAULT;


            ByteBuf buffer = allocator.buffer(1024);


            buffer.release();
        }).start();
    }
}
