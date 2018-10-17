package Thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author JYH
 * 2018/10/9 18:14
 */
public class ConcurrentHashMapIteratorDemo {
    public static void test(){
        final ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
        map.put("a", "abstract");
        map.put("b", "basic");

         Thread t1 = new Thread(){
             @Override
             public void run() {
                 for (Map.Entry<String, String> entry: map.entrySet() ){
                     try {
                         Thread.sleep(1000);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     System.out.println(entry.getKey() + "," + entry.getValue());
                 }
             }
         };
         t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map.put("g", "call");
    }

    public static void main(String[] args) {
        test();
    }
}
