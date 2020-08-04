package vip.wulang.test.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

public class DemoNetty {
    public static void main(String[] args) {
        ServerBootstrap sb = new ServerBootstrap();
        sb
                .group(new NioEventLoopGroup(1, r -> {
                    Thread t = new Thread(r);
                    t.setName("boss server");
                    t.setDaemon(false);
                    return t;
                }), new NioEventLoopGroup(1))
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(new ChannelInitializer<>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        // server端接收到的是httpRequest，所以要使用HttpRequestDecoder进行解码
                        ch.pipeline().addLast("http-decoder", new HttpRequestDecoder());
                        //将多个消息转换为单一的FullHttpRequest或FullHttpResponse对象
                        ch.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65535));
                        // server端发送的是httpResponse，所以要使用HttpResponseEncoder进行编码
                        ch.pipeline().addLast("http-encoder", new HttpResponseEncoder());
                        //解决大数据包传输问题，用于支持异步写大量数据流并且不需要消耗大量内存也不会导致内存溢出错误( OutOfMemoryError )。
                        //仅支持ChunkedInput类型的消息。也就是说，仅当消息类型是ChunkedInput时才能实现ChunkedWriteHandler提供的大数据包传输功能
                        ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());//解决大码流的问题
                        ch.pipeline().addLast("http-server", new HttpServerHandler());

//                        ch.pipeline().addLast(new DemoByteToMessageDecoder());
//                        ch.pipeline().addLast(new DemoInboundChannel());
                    }
                })
                .bind(8080);
//        sb.bind(7070);
    }
}
