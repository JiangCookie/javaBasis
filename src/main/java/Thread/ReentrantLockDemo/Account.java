package Thread.ReentrantLockDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JYH
 * 2018/10/10 8:58
 */
public class Account {
    private final Lock lock = new ReentrantLock();
    private volatile double money;
    public Account(double initialMoney){
        this.money = initialMoney;
    }
    public void add(double money){
        lock.lock();
        try {
            this.money += money;
        }finally {
            lock.unlock();
        }
    }
    public void reduce(double money){
        lock.lock();
        try {
            this.money -= money;
        }finally {
            lock.unlock();
        }
    }
    public double getMoney(){
        return money;
    }
    void lock(){
        lock.lock();
    }
    void unlock(){
        lock.unlock();
    }
    boolean trylock(){
        return lock.tryLock();
    }

    /**
     * 使用trylock（），可以避免死锁。在持有一个锁获取另一个锁而获取不到的
     * 时候，可以释放已经持有的锁，给其他线程获取锁的机会，然后重试获取所有锁
     * @param from
     * @param to
     * @param money
     * @return
     */
    public static boolean tryTransfer(Account from,Account to,double money){
        if(from.trylock()){
            try {
                if(to.trylock()){
                    try {
                        if(from.getMoney() > money){
                            from.reduce(money);
                            to.add(money);
                        }else {
                            throw new IllegalArgumentException("NoEnoughMoney");
                        }
                        return true;
                    }finally {
                        to.unlock();
                    }
                }
            }finally {
                from.unlock();
            }
        }
        return false;
    }

    public static void  transfer(Account from,Account to,double money){
        boolean success = false;
        do {
            success = tryTransfer(from, to, money);
            if(!success){
                Thread.yield();
            }
        }while (!success);
    }
}
