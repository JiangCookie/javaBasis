package Socket;

import java.io.IOException;
import java.net.*;

/**
 * 基于UDP客户端
 * @author JYH
 * 2018/9/28 9:28
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        /**
         * 向服务端发送的数据
         */

        /**
         * 1.定义服务器地址，端口号，数据
         */
        InetAddress address = InetAddress.getByName("localhost");
        int port = 8800;
        byte[] data = "用户名： admin；密码： 123".getBytes();

        /**
         * 2.创建数据报，包含发送的数据信息
         */
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);

        /**
         * 3.创建服务器端DatagramSocket对象
         */
        DatagramSocket socket = new DatagramSocket();

        /**
         * 4.向服务器端发送数据
         */
        socket.send(packet);

        /**
         * 接收服务端接收的数据
         */
        byte[] data2 = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(data2, data2.length);
        socket.receive(packet1);
        String reply = new String(data2,0,packet1.getLength());
        System.out.println("我是客户端，服务器说" + reply);
        socket.close();

    }

}
