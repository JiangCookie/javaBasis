package Generics;

/**
 * @author JYH
 * 2018/10/15 11:30
 */
public class Pari<U,V> {
    U first;
    V second;
    public Pari(U first,V second){
        this.first = first;
        this.second = second;
    }

    public U getFirst(){
        return first;
    }

    public V getSecond(){
        return second;
    }
}
