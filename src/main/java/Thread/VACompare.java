package Thread;

import java.util.ArrayList;
import java.util.Vector;


/**
 * @author JYH
 * 2018/10/8 20:47
 */
public class VACompare {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Vector<Integer> vector = new Vector<Integer>();

        /**
         * 测试ArrayList 插入性能
         */
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList进行10000次插入操作耗时：" + (end - start) + "ms");

        /**
         * 测试vector 插入性能
         */
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            vector.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Vector进行10000次插入操作耗时：" + (end - start) + "ms");
    }
}













