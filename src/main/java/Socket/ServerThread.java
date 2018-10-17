package Socket;

import java.io.*;
import java.net.Socket;

/**
 * 服务器线程处理类
 * @author JYH
 * 2018/9/28 8:10
 */
public class ServerThread  extends  Thread{
    /**
     * 和本线程相关的Socket
     */
    Socket socket = null;

    public ServerThread(Socket socket){
        this.socket = socket;
    }

    /**
     * 线程执行的操作，响应客户端的请求
     */
    @Override
    public void run(){

        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            /**
             * 3.获取输入流，读取客户端信息
             */
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String data;
            while ((data = br.readLine()) != null){
                System.out.println("我是服务器，客户端说：" + data);
            }
            socket.shutdownInput();
            /**
             * 4.获取输出流，响应客户端的请求
             */
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("欢迎您！");
            //刷新缓存
            pw.flush();
            socket.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            /**
             * 5.关闭资源
             */
            try {
                if(pw != null){
                    pw.close();
                }
                if(os != null){
                        os.close();
                }
                if(is != null){
                    is.close();
                }
                if(isr != null){
                    isr.close();
                }
                if(br != null){
                    br.close();
                }
                if(socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

}
