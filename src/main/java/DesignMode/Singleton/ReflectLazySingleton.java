package DesignMode.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 懒汉模式，多线程不安全
 * 模拟反射攻击
 * @author JYH
 * 2018/11/21 18:34
 */
public class ReflectLazySingleton {
    private  static ReflectLazySingleton lazySingleton = null;
    private static boolean flag = true;
    private ReflectLazySingleton(){
        if(flag){
            flag = false;
        }else {
            throw new RuntimeException("单例构造器禁止反射调用");
        }

    }
    public synchronized static ReflectLazySingleton getInstance(){
        if(lazySingleton == null){
            lazySingleton = new ReflectLazySingleton();
        }
        return lazySingleton;
    }


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Constructor constructor = ReflectLazySingleton.class.getDeclaredConstructor();
        //修改构造器的权限，忽略Java的访问检查机制，以允许读取非public的方法
        constructor.setAccessible(true);

        ReflectLazySingleton newInstance = ReflectLazySingleton.getInstance();

        //通过反射，可以任意修改，无论在构造方法有多复杂的逻辑
        Field field =  newInstance.getClass().getDeclaredField("flag");
        field.setAccessible(true);
        field.set(newInstance,true);


        ReflectLazySingleton instance = (ReflectLazySingleton) constructor.newInstance();



        System.out.println(instance == newInstance);

    }
}
