package Netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * 这个逻辑处理器继承自 ChannelInboundHandlerAdapter ，覆盖channelActive() 方法
 * @author JYH
 * 2018/9/27 17:31
 */
public class FirstClientHandler extends ChannelInboundHandlerAdapter {


    /**
     * 客户端连接建立成功之后，调用channelActive()方法，在这个方法里面，编写向服务端写数据的逻辑
     * @param ctx
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx){
        System.out.println(new Date() + ": 客户端写出数据");

        // 1. 获取数据
        ByteBuf buffer = getByteBuf(ctx);

        // 2. 写数据
        ctx.channel().writeAndFlush(buffer);

    }


    private ByteBuf getByteBuf(ChannelHandlerContext ctx){
        //1.获取二进制抽象 ByteBuf
        ByteBuf buffer = ctx.alloc().buffer();

        //2.准备数据，指定字符串的字符集为utf-8
        byte[] bytes = "你好，闪电侠！".getBytes(Charset.forName("utf-8"));

        //3.填充数据到 ByteBuf
        buffer.writeBytes(bytes);

        return buffer;
    }
}




















