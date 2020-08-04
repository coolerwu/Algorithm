package vip.wulang.test.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author CoolerWu
 * @version 1.0
 */
public class DemoByteToMessageDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        int readerIndex = in.readerIndex();
        int writerIndex = in.writerIndex();
        byte[] buf = new byte[writerIndex - readerIndex];

        in.readBytes(buf, readerIndex, writerIndex - readerIndex);


        out.add(buf);
    }
}
