package DesignMode.Flyweight;

/**
 * @author JYH
 * 2018/10/20 16:49
 */
public class UnsharedConcreteFlyweight extends Flyweight {
    @Override
    public void Operation(int extrinsicstate) {
        System.out.println("不共享的具体Flyweight" + extrinsicstate);
    }
}
