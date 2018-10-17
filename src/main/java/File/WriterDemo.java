package File;

import java.io.*;

/**
 * java的文本(char) 是16位无符号整数，是字符的Unicode编码（双字节编码）
 * 文件是byte byte .... 的数据序列
 * 文本文件是文本(char) 序列按照某种编码方案(utf-8,utf-16be,gbk)序列化为byte的存储文件
 * 字符流(Writer,Reader)
 * 字符的处理，一次处理一个字符
 * 字符的底层仍然是基本的字节序列
 * 字符流的基本实现
 *    InputStreamReader  完成byte流解析为char流，按照编码解析
 *    OutputStreamWriter 提供char流到byte流，按照编码处理
 * @author JYH
 * 2018/9/26 17:19
 */
public class WriterDemo {

    public static void printISR(String srcFile) throws IOException {
        FileInputStream in = new FileInputStream(srcFile);

        /**
         * 默认项目的编码，将来操作要写文件本身的编码
         */
        InputStreamReader isr = new InputStreamReader(in,"gbk");


        FileOutputStream outt = new FileOutputStream(srcFile);
        OutputStreamWriter outtt = new OutputStreamWriter(outt,"utf-8");


        int c;
        while ((c = isr.read())!= -1){
            System.out.println((char) c);
        }




        in.close();
        isr.close();
        outt.close();
        outtt.close();
    }


    /**
     * BufferedReader    readline      ----》 一次读一行
         * BufferedWriter/PrintWriter  -----》 写一行
     * @param filePath
     * @throws IOException
     */
   public static void readFileContent(String filePath) throws IOException {
       FileReader fr = new FileReader("d:");
       BufferedReader bufferedReader = new BufferedReader(fr);

       BufferedReader bfr = new BufferedReader(
               new InputStreamReader(
                       new FileInputStream(filePath)));


       String line;
       while ((line = bufferedReader.readLine()) != null){
           //不能识别换行
           System.out.println(line);
       }


       //newline()  换行操作


       // 装饰者模式使得 BufferedReader 组合了一个 Reader 对象
       // 在调用 BufferedReader 的 close() 方法时会去调用 Reader 的 close() 方法
       // 因此只要一个 close() 调用即可
       bufferedReader.close();
   }



}











