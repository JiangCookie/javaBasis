package Thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author JYH
 * 2018/10/9 14:10
 */
public class AtomicIntegerDemo1 {
    private AtomicInteger status = new AtomicInteger(0);
    public void lock(){
        while (! status.compareAndSet(0,1)){

        }
    }
}
