package Jichu.Interface;

/**
 * @author JYH
 * 2018/10/20 11:30
 */
public interface IAdd {
    void add(int number);
    void addAll(int[] numbers);

    default void hi(){
        System.out.println("hi");
    }

}
