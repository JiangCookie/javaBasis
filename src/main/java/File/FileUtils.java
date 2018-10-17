package File;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * 列出File 的一些常用操作比如过滤，遍历等操作
 * File类可以用于表示文件和目录的信息，但是它不表示文件的内容
 * @author JYH
 * 2018/9/26 10:17
 */
public class FileUtils {
    public static void listDirectory(File dir){

        if(!dir.exists()){
            throw new IllegalArgumentException("目录：" + dir + "不存在");
        }
        if(!dir.isDirectory()){
            throw new IllegalArgumentException(dir + "不是目录");
        }
        //list() 方法用于列出当前目录下的子目录和文件
        String[] filenames = dir.list();
        for (String file: filenames){
            System.out.println(dir+"\\"+file);
        }
    }

    /**
     * 递归地列出一个目录下所有文件
     */
    public void listAllfiles(File dir){
        if(dir == null || !dir.exists()){
            return ;
        }
        if(dir.isFile()){
            System.out.println(dir.getName());
            return  ;
        }
        for(File file : dir.listFiles()){
            listAllfiles(file);
        }
    }
}
