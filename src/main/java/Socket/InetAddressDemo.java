package Socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * InetAddress类
 * @author JYH
 * 2018/9/27 20:09
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        /**
         * 获取本机的InetAddress实例
         */
        InetAddress address = InetAddress.getLocalHost();

        /**
         * 获取本机的计算机名
         */
        String hostName = address.getHostName();

        /**
         * 获取本机的IP地址
         */
        String hostAddress = address.getHostAddress();

        /**
         * 获取字节数组形式的IP地址
         */
        byte[] byteAddress = address.getAddress();

        /**
         * 根据机器名获取InetAddress实例
         */
        InetAddress address1 = InetAddress.getByName("LAPTOP-9483PUCQ");
        InetAddress address2 = InetAddress.getByName("192.168.236.1");

        System.out.println(hostName);
        System.out.println(hostAddress);
        System.out.println(Arrays.toString(byteAddress));
        System.out.println(address1);
        System.out.println(address2.getHostName());
    }
}
