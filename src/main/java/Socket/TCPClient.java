package Socket;

import java.io.*;
import java.net.Socket;

/**
 * 客户端
 * @author JYH
 * 2018/9/27 21:27
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        /**
         * 1.创建客户端Socket,指定服务器地址和端口
         */
        Socket socket = new Socket("localhost", 8888);

        /**
         * 2.获取输出流，向服务器端发送消息
         */
        OutputStream os = socket.getOutputStream();
        //将输出流包装为打印流
        PrintWriter pw = new PrintWriter(os);
        pw.write("用户名： admin;密码: 123");
        pw.flush();

        /**
         * Socket类的两个方法：shutdownInput和shutdownOutput，
         *      这两个方法只关闭相应的输入、输出流，而它们并没有同时关闭网络连接的功能。
         * 关闭输出流
         */
        socket.shutdownOutput();
        /**
         *3. 获取输入流，用来读取服务端的响应信息
         */
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String info ;
        while ((info = br.readLine()) != null){
            System.out.println("我是客户端，服务器说：" + info);
        }
        socket.shutdownInput();
        /**
         * 4.关闭资源
         */
        is.close();
        isr.close();
        br.close();
        //不能关闭输出流，会导致socket也被关闭，所以一般直接关闭socket
//        pw.close();
        os.close();
        socket.close();
    }

    /**
     * 使用TCP通信传输对象
     */
    public static  void  sendObject() throws IOException {
        /**
         * 1.创建客户端Socket,指定服务器地址和端口
         */
        Socket socket1 = new Socket("localhost", 8888);

        /**
         * 2.获取输出流，向服务器端发送消息
         */
        OutputStream os = socket1.getOutputStream();

        /**
         * 使用
         */
        ObjectOutputStream oos = new ObjectOutputStream(os);

        //User user =new User("admin", "123");  封装对象
        //oos.writeObject(user);  序列化

    }
}
