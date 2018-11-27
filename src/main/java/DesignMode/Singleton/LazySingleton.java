package DesignMode.Singleton;

/**
 * 懒汉模式，多线程不安全
 * synchronized 使用可解决多线程下不安全的问题，但加锁和解锁会增大线程的开销
 * @author JYH
 * 2018/11/21 18:34
 */
public class LazySingleton {
    private  static LazySingleton lazySingleton = null;
    private LazySingleton(){

    }
    public synchronized static LazySingleton getInstance(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }


    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                LazySingleton lazySingleton = LazySingleton.getInstance();
                System.out.println(Thread.currentThread().getName() + "  " + lazySingleton);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                LazySingleton lazySingleton = LazySingleton.getInstance();
                System.out.println(Thread.currentThread().getName() + "  " + lazySingleton);
            }
        });

        thread1.start();
        thread2.start();

    }
}
