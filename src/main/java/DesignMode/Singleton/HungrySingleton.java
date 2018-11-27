package DesignMode.Singleton;

import java.io.Serializable;

/**
 * 饿汉模式，使用final保证类加载时即初始化。而懒汉模式采用延迟加载，所以不能使用final
 * 缺点，资源浪费
 * @author JYH
 * 2018/11/21 20:55
 */
public class HungrySingleton{
    private final static HungrySingleton hungrySingleton = new HungrySingleton();
    private HungrySingleton(){

    }
    public HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
