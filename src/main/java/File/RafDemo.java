package File;

import Arithmetic.Array.Array;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * RandomAccessFile java提供的对文件内容的访问，既可以读文件，也可以写文件
 * RandomAccessFile  支持随机访问文件，可以访问文件的任意位置
 * (1)java文件模型
 *      在硬盘上的文件是byte byte存储的是数据的集合
 * (2)打开文件
 *      两种模式  “rw”（读写） “r“（只读）
 *      RandomAccessFile raf = new RandomAccessFile(file,"rw")
 *      文件指针，打开文件时指针在开头pointer = 0
 * (3)写方法
 *      raf.write(int) ---> 只写一个字节（后八位），同时指针指向下一个位置，准备再次写入
 * (4)读方法
 *      int b = raf.read() ---->读一个字节
 * (5)关闭
 *      文件读写完成以后一定要关闭(Oracle 官方说明)
 * @author JYH
 * 2018/9/26 11:00
 */
public class RafDemo {

    public static void main(String[] args) throws IOException {
        File demo = new File("demo");
        if(!demo.exists()){
            demo.mkdir();
        }

        File file = new File(demo,"raf.dat");
        if(!file.exists()){
            file.createNewFile();
        }

        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        //指针位置
        System.out.println(raf.getFilePointer());

        //只写了一个字节
        raf.write('A');
        System.out.println(raf.getFilePointer());
        raf.write('B');

        int i = 0x7fffffff;
        /**
         * 用write方法每次只能写一个字节，如果要把i写进去就得写4次
         */
        raf.write(i >>> 24);
        raf.write(i >>> 16);
        raf.write(i >>> 8);
        raf.write(i );
        System.out.println(raf.getFilePointer());

        /**
         * writeInt  直接写入
         */
        raf.writeInt(i);

        String s = "中";
        byte[] gbk = s.getBytes("gbk");
        raf.write(gbk);
        System.out.println(raf.length());


        //读文件，必须把指针移到头部
        raf.seek(0);
        //一次性读取，把文件中的内容都读到字节数组中
        byte[] buf = new byte[(int)raf.length()];
        raf.read(buf);
        System.out.println(Arrays.toString(buf));

        raf.close();

    }
}
