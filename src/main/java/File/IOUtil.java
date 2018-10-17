package File;

import java.io.*;

/**
 * @author JYH
 * 2018/9/26 11:46
 */
public class IOUtil {

    /**
     *
     * EOF = End 读到 -1 就读到结尾
     * 输入流基本方法
     * int b =in.read()  读取一个字节无符号填充到int 低八位 -1 是EOF
     * in.read(byte[] buf)  读取数据填充到字节数组buf
     * 输出流基本方法
     * out.write(int b)  写出一个byte到流，b的低8位
     * out.wirte(byte[] buf) 将buf字节数组都写入到流
     *
     *
     *
     *
     * 读取指定文件内容，按照16进制输出到控制台，并且每输出10个byte换行
     * @param fileName
     */
    public static void printHex(String fileName) throws IOException {

        //具体实现了在文件上读取数据
        FileInputStream in = new FileInputStream(fileName);
        int b;
        int i = 1;
        while ((b = in.read()) != -1){
            if(b <= 0xf){
                //单位数面前补0
                System.out.print("0");
            }

            /**
             * 将整形b转换为16进制表示的字符串
             */
            System.out.println(Integer.toHexString(b)+"  ");
            if(i++ % 10 == 0){
                System.out.println();
            }
        }
        in.close();
    }

    public static void printHexByByteArray(String filename) throws IOException {
        FileInputStream in = new FileInputStream(filename);
        byte[] buf = new byte[20 * 1024];

        /**
         * 从in读取字节放入到buf这个字节数组中，
         * 从第0个位置开始放，最多放buf.length个，
         * 返回的是读到的字节的个数
         * 一次性读完，说明字节数组足够大
         */
        int bytes = in.read(buf,0,buf.length);
        for(int i = 0;i<bytes ;i++){
            if(buf[i] <= 0xf){
                System.out.print("0");
            }
            System.out.println(Integer.toHexString(buf[i]) + " ");
        }
    }

    public static void writeFileOutput(String filename) throws IOException {
        /**
         * 如果该文件不存在，则直接创建，如果存在，删除后创建
         * FileOutputStream out = new FileOutputStream(filename);
         * 加参数 true的话，则采用追加方式
         * FileOutputStream out = new FileOutputStream(filename，true);
         */
        FileOutputStream out = new FileOutputStream(filename);
        //写出了‘A’的低八位
        out.write('A');
        //写出了‘B’的低八位
        out.write('B');

        /**
         * write() 只能写八位，那么写一个int需要4次每次8位
         */
        int a = 10;
        out.write(a >>> 24);
        out.write(a >>> 16);
        out.write(a >>> 8);
        out.write(a );

        byte[] gbk = "中国".getBytes("gbk");
        out.write(gbk);

        out.close();
    }


    /**
     * 对流功能的扩展，可以更加方便的读取int，string，字符等类型数据
     * @param filename
     * @throws IOException
     */
    public static void writeDataOutput(String filename) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename));
        dos.writeInt(10);
        dos.writeInt(-10);
        dos.writeLong(10);
        dos.writeDouble(10.5);

        /**
         * 采用utf-8编码写出
         */
        dos.writeUTF("中国");
        /**
         * 采用utf-16编码写出
         */
        dos.writeChars("中国");
        dos.close();


    }

    /**
     * 进行文件的拷贝，利用带缓冲的字节流
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void coyFileByBuffer(File srcFile, File destFile) throws IOException{
        if(!srcFile.exists()){
            throw new IllegalArgumentException("文件" + srcFile + "不存在");
        }
        if(!srcFile.isFile()){
            throw new IllegalArgumentException(srcFile + "不是文件");
        }

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

        int c;
        while ((c = bis.read()) != -1){
            bos.write(c);
            //刷新缓冲区
            bos.flush();
        }

        bis.close();
        bos.close();
    }
}























