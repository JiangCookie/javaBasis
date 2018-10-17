package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL常用方法
 * @author JYH
 * 2018/9/27 20:38
 */
public class URLDemo {

    public static void getUrlStream() throws MalformedURLException {
        URL url = new URL("http://www.baidu.com");
        try {
            /**
             * 通过URL的openStream方法获取URL对象所表示的资源的字节输入流
             */
            InputStream inputStream =  url.openStream();
            InputStreamReader isr = new InputStreamReader(inputStream,"utf-8");
            BufferedReader bsr = new BufferedReader(isr);
            String data ;
            while ((data = bsr.readLine()) != null){
                System.out.println(data);

            }
            bsr.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws MalformedURLException {
        /**
         * 创建一个URL实例
         */
        URL imooc = new URL("http://www.imooc.com");

        /**
         * ? 表示参数
         * # 表示锚点
         * 创建一个新的url
         */
        URL url = new URL(imooc, "/index.html?username=tom#test");

        //协议
        url.getProtocol();
        //主机
        url.getHost();

        /**
         * 如果未指定端口号，则使用默认端口号，此时getPort()返回值为-1
         */
        url.getPort();
        //文件路径
        url.getPath();
        //文件名
        url.getFile();
        //相对路径
        url.getRef();
        //查询字符串
        url.getQuery();

        getUrlStream();
    }
}
