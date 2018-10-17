package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author JYH
 * 2018/9/25 18:24
 */
public class PrintClassMessage {
    public  static  void printClass(Object obj){
        /**
         * 要获取类的信息  首先要获取类的类类型
         * 传递的是哪个子类的对象  c就是该子类的类类型
         */
        Class c = obj.getClass();

        //获取类的名称
        System.out.println("类的名称是" + c.getName());

        /**
         * Method类 ，方法对象
         * 一个成员方法就是一个Method对象
         *         getMethods()  方法获取的所有的public 的函数，包括父类继承而来的
         * getDeclaredMethods()  获取的是所有该类自己声明的方法，不访问父类
         */
        Method[] ms = c.getMethods();
        for (int i = 0; i < ms.length; i ++){
            //得到方法的返回值类型的类类型
            Class returnType = ms[i].getReturnType();
            System.out.print(returnType.getName() + "  ");
            //得到方法的名称
            System.out.print(ms[i].getName() + "  ");

            //获取参数类型  ---》 得到的是参数列表的类型的类类型
            Class[]  paramTypes = ms[i].getParameterTypes();
            for (Class class1: paramTypes){
                System.out.println(class1.getName()+ "  ");
            }

            System.out.println(")");

        }

        /**
         * 成员变量也是对象
         * java.lang.reflect.Field
         * Field 类封装了关于成员变量的操作
         * getFields()方法获取的是所有的public的成员变量的信息
         * getDeclaredFields() 方法是获取的该类自己声明的成员变量的信息
         */
        Field[] fs = c.getDeclaredFields();
        for(Field field: fs){
            //得到成员变量的类型的类类型
            Class fieldType = field.getType();
            String typeName = fieldType.getName();
            //得到成员变量的名称
            String fieldName = field.getName();
            System.out.println(typeName + "  "+ fieldName);
        }
    }


    public static void printConMessage(Object obj){
        Class cs =obj.getClass();
        /**
         * 构造函数也是对象
         * java.lang.Constuctor 中封装了构造函数的信息
         * getConstructors() 获取所有的public 的构造函数
         * getDeclaredConstructors() 得到所有的构造函数
         */
        Constructor[] constructor = cs.getDeclaredConstructors();
        for(Constructor constructor1:constructor){
            System.out.println(constructor1.getName() + "(");

            //获取构造函数的参数列表 ---》 得到是参数列表的类类型
            Class[] paramTypes = constructor1.getParameterTypes();
            for (Class class1:paramTypes){
                System.out.println(class1.getName()+",");
            }
        }
    }

}
