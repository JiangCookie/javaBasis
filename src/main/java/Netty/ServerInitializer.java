package Netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * 初始化器，channel注册后，会执行里面的相应的初始化方法
 * @author JYH
 * 2018/9/28 19:18
 */
public class ServerInitializer  extends ChannelInitializer<SocketChannel> {



    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //通过SocketChannel去获得对应的管道pipline
        ChannelPipeline pipeline = socketChannel.pipeline();
        /**
         * 通过管道，添加handler
         * HttpServerCodec 是由netty自己提供的助手类，可以理解为拦截器
         * 当请求到服务端，我们需要要编解码，响应到客户端做编码
         */
        pipeline.addLast("HttpServerCodec", new HttpServerCodec());

        /**
         * 添加自定义助手类，返回“hello netty”
         */
        pipeline.addLast("customhandler", null);
    }
}
