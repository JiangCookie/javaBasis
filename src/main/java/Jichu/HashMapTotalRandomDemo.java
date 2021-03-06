package Jichu;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author JYH
 * 2018/10/17 16:00
 */
public class HashMapTotalRandomDemo {
    public static void main(String[] args) {
        Random rnd = new Random();
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            int num = rnd.nextInt(4);
            Integer count =countMap.get(num);
            if (count == null){
                countMap.put(num,1);
            }else {
                countMap.put(num, count + 1);
            }
        }

        for (Map.Entry<Integer,Integer> kv: countMap.entrySet()) {
            System.out.println(kv.getKey() + " " + kv.getValue());

        }

        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("world");
        set.addAll(Arrays.asList(new String[]{"hello","老马"}));
        for(String arr:set){
            System.out.println(arr);
        }
    }
}
