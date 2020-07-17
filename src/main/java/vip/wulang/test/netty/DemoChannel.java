package vip.wulang.test.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.StandardCharsets;

public class DemoChannel extends SimpleChannelInboundHandler<ByteBuf> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        String content = msg.toString(StandardCharsets.UTF_8);

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
}
