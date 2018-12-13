package Socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 服务器端，实现基于UDP的用户登录
 * @author JYH
 * 2018/9/28 9:28
 */
public class UDPServer {
    public static void main(String[] args) throws IOException {
        /**
         * 接收客户端发送的数据
         */

        /**
         * 1.创建服务器端DatagramSocket, 指定端口
         */
        DatagramSocket socket = new DatagramSocket(8800);

        /**
         * 2.创建数据报
         */
        byte[] data = new byte[1024];
        DatagramPacket receivePack = new DatagramPacket(data, data.length);

        /**
         * 3.接收客户端的数据
         * receive() 此方法在接收到数据表之前会一直阻塞
         */
        System.out.println("****服务器端已经启动，等待客户端发送数据****");
        socket.receive(receivePack);

        /**
         * 4.读取数据
         */
        String info = new String(data, 0, receivePack.getLength());
        System.out.println("我是服务器， 客户端说：" + info);

        /**
         * 5.向客户端响应数据
         */
        InetAddress address = receivePack.getAddress();
        int post = receivePack.getPort();
        byte[] data2 = "欢迎您！".getBytes();

        DatagramPacket responsePack = new DatagramPacket(data2, data2.length, address, post);

        socket.send(responsePack);

        socket.close();
    }
}
