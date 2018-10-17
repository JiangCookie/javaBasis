package File;

import java.io.File;
import java.io.IOException;

/**
 * @author JYH
 * 2018/9/26 9:43
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("D:/text.txt");
        if(!file.exists()){
            file.mkdir();
        }else {
            file.delete();
        }

        //是否是一个目录  如果是目录返回true，如果不是目录or目录不存在返回false
        System.out.println(file.isDirectory());

        //是否是一个文件
        System.out.println(file.isFile());

        File file1 = new File("d:/日记.txt");
        if(!file1.exists()){
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            file1.delete();
        }


        //常用的File 对象的API
        System.out.println(file);
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getName());
        System.out.println(file.getParentFile().getAbsoluteFile());
    }
}
