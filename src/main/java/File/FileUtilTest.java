package File;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * @author JYH
 * 2018/9/26 10:23
 */
public class FileUtilTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        FileUtils.listDirectory(new File("D:\\Work"));



        String str1 = "中文";
        byte[] bytes = str1.getBytes("utf-8");
        String str2 = new String(bytes,"UTF-8");
        System.out.println(bytes);
    }
}
