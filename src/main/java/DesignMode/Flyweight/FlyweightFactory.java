package DesignMode.Flyweight;


import java.util.Hashtable;

/**
 * @author JYH
 * 2018/10/20 16:50
 */
public class FlyweightFactory {
    private Hashtable flyweight = new Hashtable();



    public Flyweight getFlyweight(String key){
        if(!flyweight.containsKey(key)){
            flyweight.put(key,new ConcreteFlyweight());
        }
        return ((Flyweight) flyweight.get(key));
    }
}
