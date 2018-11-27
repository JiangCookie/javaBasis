package DesignMode.Singleton;



import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 单例设计模式-反射攻击解决方案
 * @author JYH
 * 2018/11/21 21:18
 */
public class ReflectHungrySingleton {
    private final static ReflectHungrySingleton reflectHungrySingleton;
    static {
        reflectHungrySingleton = new ReflectHungrySingleton();
    }


    private ReflectHungrySingleton(){
        if(reflectHungrySingleton != null){
            throw new RuntimeException("单例构造器禁止反射调用");
        }

    }
    public static ReflectHungrySingleton getInstance(){
        return reflectHungrySingleton;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class cls = ReflectHungrySingleton.class;
        Constructor constructor = cls.getDeclaredConstructor();

        //newInstance方法只能使用默认的构造方法
        ReflectHungrySingleton newInstance = (ReflectHungrySingleton) constructor.newInstance();

        ReflectHungrySingleton instance =ReflectHungrySingleton.getInstance();

        System.out.println(newInstance);
        System.out.println(instance);
        System.out.println(newInstance ==  instance);
    }
}
