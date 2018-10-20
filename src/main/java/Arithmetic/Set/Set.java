package Arithmetic.Set;

/**
 * @author JYH
 * 2018/10/18 16:46
 */
public interface Set<E> {


    void add(E e);
    boolean contains(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();
}
