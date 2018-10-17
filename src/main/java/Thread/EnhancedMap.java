package Thread;

import java.util.Collections;
import java.util.Map;

/**
 * EnhancedMap装饰类，接受一个Map对象
 * @author JYH
 * 2018/10/9 9:43
 */
public class EnhancedMap <K,V> {
    Map<K,V> map;
    public EnhancedMap(Map<K,V> map){
        this.map = Collections.synchronizedMap(map);

    }
}
