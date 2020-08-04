package vip.wulang.test.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;

public class DemoInboundChannel extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof ByteBuf) {
            String content = ((ByteBuf) msg).toString(StandardCharsets.UTF_8);

            if (content == null) {
                ctx.writeAndFlush("error");
            } else {
                ctx.writeAndFlush("Status: ok\n" +
                        "access-control-allow-origin: *\n" +
                        "cache-control: public,max-age=25920000\n" +
                        "content-encoding: gzip\n" +
                        "content-type: application/javascript\n" +
                        "date: Tue, 30 Jun 2020 01:40:46 GMT\n" +
                        "last-modified: Tue, 09 Feb 2016 15:15:15 GMT\n" +
                        "status: 200\n" +
                        "vary: Accept-Encoding");
            }
        }
        if (msg instanceof byte[]) {
            System.out.println("hhhhhhhh");
            ByteBuf byteBuf = UnpooledByteBufAllocator.DEFAULT.directBuffer(100);
            byteBuf.writeBytes(("Status: ok\n" +
                    "access-control-allow-origin: *\n" +
                    "cache-control: public,max-age=25920000\n" +
                    "content-encoding: gzip\n" +
                    "content-type: application/javascript\n" +
                    "date: Tue, 30 Jun 2020 01:40:46 GMT\n" +
                    "last-modified: Tue, 09 Feb 2016 15:15:15 GMT\n" +
                    "status: 200\n" +
                    "vary: Accept-Encoding").getBytes());
            ChannelFuture future = ctx.writeAndFlush(byteBuf);

            future.sync();
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("????");
    }
}
