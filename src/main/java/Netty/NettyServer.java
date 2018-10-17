package Netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/**
 * 要启动一个Netty服务端，
 * 必须要指定三类属性，分别是线程模型、IO 模型、连接读写处理逻辑，有了这三者，之后在调用bind(8000)
 * @author JYH
 * 2018/9/27 16:34
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 两个对象可以看做是传统IO编程模型的两大线程组
         * bossGroup   主线程组   表示监听端口，接收客户端的连接，但是不做任何处理
         * workerGroup 从线程组   表示主线程组会把任务分配给从线程组，处理每一条连接的数据读写的线程组
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        /**
         * 创建了一个引导类 ServerBootstrap，这个类将引导我们进行服务端的启动工作
         * .group(bossGroup, workerGroup)给引导类配置两大线程组
         * .channel(NioServerSocketChannel.class) 指定我们服务端的 IO 模型为NIO
         * .childHandler()方法，给这个引导类创建一个ChannelInitializer，这里主要就是定义后续每条连接的数据读写，业务处理逻辑
         */
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        try {
            serverBootstrap
                    //设置主从线程组
                    .group(bossGroup, workerGroup)
                    //设置nio的双向通道
                    .channel(NioServerSocketChannel.class)
                    //子处理器，用于处理workerGroup
                    .childHandler(new ServerInitializer());

//        bind(serverBootstrap, 1000);
            /**
             * 启动server,并且设置为8088为启动的端口号，同时启动方式为同步
             */
            ChannelFuture channelFuture = serverBootstrap.bind(8088).sync();

            /**
             * 监听关闭的channel,设置为同步方式
             */
            channelFuture.channel().close().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }


    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) {
                if (future.isSuccess()) {
                    System.out.println("端口[" + port + "]绑定成功!");
                } else {
                    System.err.println("端口[" + port + "]绑定失败!");
                    bind(serverBootstrap, port + 1);
                }
            }
        });
    }


}













