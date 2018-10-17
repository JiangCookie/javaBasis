package Arithmetic.Queue;

/**
 * @author JYH
 * 2018/9/21 11:16
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
