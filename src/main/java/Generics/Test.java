package Generics;

import java.util.Random;

/**
 * @author JYH
 * 2018/10/15 11:32
 */
public class Test {
    public static void main(String[] args) {
        DynamicArray<Number> number = new DynamicArray<>();
        DynamicArray<Integer> ints = new DynamicArray<>();
        ints.add(100);
        ints.add(34);
        number.addAll(ints);



        DynamicArray<? extends Number> numbers = ints;
        Integer a = 200;

    }

}
