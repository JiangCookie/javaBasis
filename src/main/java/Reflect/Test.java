package Reflect;

import java.util.MissingResourceException;

/**
 * @author JYH
 * 2018/9/25 15:15
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
         /**
         * 任何一个类都是class的实例对象，这个实例对象有三种表示方式
         */
        Test test =new Test();
        System.out.println(test.getClass());
        System.out.println(Test.class);

        /**
         * 不仅表示类的类类型，还代表了动态加载类
         */
        Class a = Class.forName("Reflect.Test");
        System.out.println(a);

        //int 的类类型
        Class c1 = int.class;

        System.out.println(c1.getName());


        //获取类的名称

    }
}
