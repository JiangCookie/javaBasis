package DesignMode.Singleton;

/**
 * 双重检查
 * @author JYH
 * 2018/11/21 19:09
 */
public class LazyDoubleCheckSingleton {
    //加volatile，解决指令重排问题
    private volatile   static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;
    private LazyDoubleCheckSingleton(){

    }
    public static LazyDoubleCheckSingleton getInstance(){
        if(lazyDoubleCheckSingleton == null){
            //降低synchronized加在方法上性能开销
            synchronized (LazyDoubleCheckSingleton.class){
                if(lazyDoubleCheckSingleton == null){
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                    //1.分配内存给这个对象
                    //2.初始化对象
                    //3.设置lazyDoubleCheckSingleton 指向刚分配的内存对象
                    //2,3可能发生重排序
                }
            }

        }
        return lazyDoubleCheckSingleton;
    }
}
