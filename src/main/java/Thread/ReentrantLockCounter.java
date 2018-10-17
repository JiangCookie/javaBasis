package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JYH
 * 2018/10/10 8:48
 */
public class ReentrantLockCounter {
    private final Lock lock = new ReentrantLock();
    private volatile int count;
    public void incr(){
        lock.lock();
        try {
            count ++;
        }finally {
            lock.unlock();
        }

    }
    public int getCount(){
        return count;
    }
}
