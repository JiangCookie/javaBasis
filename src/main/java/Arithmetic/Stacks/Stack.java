package Arithmetic.Stacks;

/**
 * @author JYH
 * 2018/9/21 9:11
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
