package DesignMode.SimpleFactory;

/**
 * @author JYH
 * 2018/9/25 13:48
 */
public class Test {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct(1);
    }
}
