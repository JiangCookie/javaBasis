package File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用NIO快速复制文件
 * @author JYH
 * 2018/9/26 12:30
 */
public class NIO {
    public static  void  fastCopy(String src,String dist) throws IOException {

        /**
         * 获取源文件的输入字节流
         */
        FileInputStream fin = new FileInputStream(src);

        /**
         * 获取输入字节流的文件通道
         */
        FileChannel fcin = fin.getChannel();

        /**
         * 获取目标文件的输出字节流
         */
        FileOutputStream fout = new FileOutputStream(dist);

        /**
         * 获取输出字节流的文件通道
         */
        FileChannel fcout = fout.getChannel();

        /**
         * 为缓冲区分配 1024 个字节
         */
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        /**
         * 将现有的一个数组转换为缓冲区
         * 使用wrap（） 方法 将一个数组包装为缓冲区。必须非常小心地进行这类操作。
         * 一旦完成包装，底层数据就可以通过缓冲区或者直接访问
         */
        byte[] array = new byte[1024];
        ByteBuffer buffer1 =ByteBuffer.wrap(array);


        /**
         * 缓冲区分片 slice() 方法根据现有的缓存区创建一个子缓冲区
         */
        ByteBuffer buffer2 =ByteBuffer.allocate(10);

        /**
         * 调用缓冲区的 asReadOnlyBuffer() 方法，
         * 将任何常规缓冲区转换为只读缓冲区，
         * 这个方法返回一个与原缓冲区完全相同的缓冲区(并与其共享数据)，
         * 只不过它是只读的。
         */
        ByteBuffer bufferRead = buffer2.asReadOnlyBuffer();

        for(int i = 0; i < buffer.capacity(); i ++){
            buffer2.put((byte) i);
        }
        buffer2.position(3);
        buffer2.limit(7);
        ByteBuffer slice = buffer2.slice();


        while(true){
            /**
             * 从输入通道中读取数据到缓冲区
             */
            int r = fcin.read(buffer);

            /**
             * read() 返回 -1 表示 EOF
             */
            if(r == -1){
                break;
            }

            /**
             * 切换读写
             */
            buffer.flip();

            /**
             * 把缓冲区的内容写入输出文件中
             */
            fcout.write(buffer);

            /**
             * 清空缓冲区,使它可以接受读入的数据
             *
             */
            buffer.clear();
        }
    }
}
