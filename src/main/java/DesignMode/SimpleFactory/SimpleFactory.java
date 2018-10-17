package DesignMode.SimpleFactory;

/**
 * 它把实例化的操作单独放到一个类中，让简单工厂类来决定应该用哪个具体子类类实例化
 * 它被所有需要进行实例化的客户类调用
 * @author JYH
 * 2018/9/23 19:22
 */
public class SimpleFactory {
    public Product createProduct(int type){
        if(type == 1){
            return new ConcreteProduct1();
        }else if(type == 2){
            return new ConcreteProduct2();
        }

        return new ConcreteProduct();
    }


}
