package Arithmetic.Array;

/**
 * @author JYH
 * 2018/9/23 9:21
 */
public class Test {
    public static void main(String[] args) {
        Array<Integer> arr =new Array<Integer>();
        for(int i = 0 ; i< 10 ; i ++){
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);
    }
}
