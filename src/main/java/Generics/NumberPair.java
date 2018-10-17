package Generics;

/**
 * @author JYH
 * 2018/10/15 12:30
 */
public class NumberPair<U extends Number,V extends Number>
        extends Pari<U,V>  {

    public NumberPair(U first, V second) {
        super(first, second);
    }

    public double sum(){
        return getFirst().doubleValue() + getSecond().doubleValue();
    }

    public static void main(String[] args) {

        NumberPair<Integer,Double> pair = new NumberPair<>(10,3.14);
        double sum = pair.sum();
    }
}
