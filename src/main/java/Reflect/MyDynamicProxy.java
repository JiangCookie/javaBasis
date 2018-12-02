package Reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author JYH
 * 2018/12/2 12:16
 */
public class MyDynamicProxy {
    static interface Hello{
        void sayHello();
    }

    static class HelloImpl implements Hello{

        @Override
        public void sayHello() {
            System.out.println("Hello World");
        }
    }

    static class MyInvocationHandler implements InvocationHandler{
        private Object realObj;
        public  MyInvocationHandler(Object realObj){
            this.realObj = realObj;
        }


        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            System.out.println("Invoking sayHello");
            Object result = method.invoke(realObj,args);

            return result;
        }
    }


    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        MyInvocationHandler handler = new MyInvocationHandler(hello);
        Hello proxyHello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(),new Class<?>[] {Hello.class},handler);
        proxyHello.sayHello();
    }

}
