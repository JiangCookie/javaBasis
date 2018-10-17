package Socket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于TCP协议的Socket通信，实现用户登录
 * 服务端
 * @author JYH
 * 2018/9/27 21:27
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        /**
         * 1.创建一个服务器端Socket，即ServerSocket,指定绑定的端口，并监听此端口
         */
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = null;
        /**
         * 记录客户端的数量
         */
        int count = 0;
        /**
         * 2.调用accept()方法开始监听，等待客户端的连接
         */
        System.out.println("***服务器即将启动，等待客户端的连接***");
        /**
         * 循环侦听，等待客户端连接
         */
        while (true){
            /**
             * 调用accept方法开始监听，等待客户端的连接
             */
            socket = serverSocket.accept();
            /**
             * 创建一个新的线程
             */
            ServerThread serverThread = new ServerThread(socket);
            /**
             * 设置线程的优先级，范围为[1,10] 默认为5
             */
            serverThread.setPriority(4);
            serverThread.start();

            count ++;
            System.out.println("客户端的数量" + count);
            InetAddress address = socket.getInetAddress();
            System.out.println("当前客户端的IP：" + address.getHostAddress());
        }
    }
}
