package DesignMode.Singleton;

/**
 * 基于类初始化的延迟加载
 * @author JYH
 * 2018/11/21 20:41
 */
public class StaticInnerClassSingleton {
    private static class InnnerClass{
        private static  StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance(){
        return InnnerClass.staticInnerClassSingleton;
    }

    //一定要有私有构造器，否则外部类可以直接new出来
    private StaticInnerClassSingleton(){

    }
}
