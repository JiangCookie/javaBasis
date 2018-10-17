package Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author JYH
 * 2018/9/25 19:51
 */
public class MethodDemo {
    /**
     * 获取print(int a, int b) 方法
     * 1.要获取一个方法就是获取类的信息，获取类的信息先要类的类类型
     * 2.获取方法 名称和参数列表来决定
     */
    public void getMeth(){
        A a1 = new A();
        Class cs = a1.getClass();
        try {
         //  Method m = cs.getMethod("print", new Class[]{int.class,int.class});
          Method m = cs.getMethod("print", int.class, int.class);



          //方法如果没有返回值返回null   ，有具体返回值返回具体的值
         Object o = m.invoke(a1,new Object[]{10, 20});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }




}


class A{
    public void print(int a, int b){
        System.out.println(a + b);
    }

    public void print(String a, String b){
        System.out.println(a.toUpperCase()+ ","+b.toLowerCase() );
    }
}