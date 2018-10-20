package DesignMode.Flyweight;

/**
 * @author JYH
 * 2018/10/20 16:56
 */
public class Client {
    public static void main(String[] args) {
        int extrinsicstate = 22;
        FlyweightFactory f = new FlyweightFactory();

        Flyweight  fx = f.getFlyweight("X");
        fx.Operation(--extrinsicstate);

        Flyweight  fy = f.getFlyweight("Y");
        fx.Operation(--extrinsicstate);

        Flyweight  fz = f.getFlyweight("Z");
        fx.Operation(--extrinsicstate);

        UnsharedConcreteFlyweight uf = new UnsharedConcreteFlyweight();
        uf.Operation(--extrinsicstate);


    }
}

















