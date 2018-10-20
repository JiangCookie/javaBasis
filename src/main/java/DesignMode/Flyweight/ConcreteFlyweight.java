package DesignMode.Flyweight;

/**
 * @author JYH
 * 2018/10/20 16:48
 */
public class ConcreteFlyweight  extends Flyweight {
    @Override
    public void Operation(int extrinsicstate) {
        System.out.println("具体Flyweight" + extrinsicstate);
    }
}
