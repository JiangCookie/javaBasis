package DesignMode.Singleton;

/**
 * 懒汉模式
 * @author JYH
 * 2018/9/23 19:21
 */
public class Singleton1 {


    private static Singleton1 uniqueInstance;

    private Singleton1(){

    }

    /**
     * 并发环境下很可能出现多个Singleton实例
     * @return
     */
    public static Singleton1 getUniqueInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Singleton1();
        }

        return  uniqueInstance;
    }

    /**
     * 1.在getInstance方法上加同步
     * @return
     */
    public static synchronized Singleton1 getUniqueInstance1 (){
        if(uniqueInstance == null){
            uniqueInstance = new Singleton1();
        }

        return  uniqueInstance;
    }



    /**
     * 2、双重检查锁定
     * volatile 可以禁止JVM 的指令重排，保证多线程情况下也能正常进行
     * @return
     */
    private volatile static Singleton1 uniqueInstance2;

    public static Singleton1 getUniqueInstance2 (){
        if(uniqueInstance2 == null){
            synchronized (Singleton1.class){
                if(uniqueInstance2 == null){
                    uniqueInstance2 = new Singleton1();
                }
            }
        }

        return  uniqueInstance2;
    }

    /**
     * 3、静态内部类
     * @return
     */

    private static class Unique{
        private static final Singleton1 uniqueInstance1 = new Singleton1();
    }

    public static Singleton1 getUniqueInstance3 (){

        return  Unique.uniqueInstance1;
    }
}
