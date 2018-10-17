package Generics;

import Arithmetic.Array.Array;

import java.util.Arrays;
import java.util.Random;

/**
 * @author JYH
 * 2018/10/15 11:44
 */
public class DynamicArray<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elementData;
    public DynamicArray(){
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity(int minCapacity){
        int oldCapacity = elementData.length;
        if(oldCapacity >= minCapacity){
            return;
        }
        int newCapacity = oldCapacity*2;
        if(newCapacity < minCapacity){
            newCapacity = minCapacity;
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public void add(E e){
        ensureCapacity(size + 1);
        elementData[size ++] = e;
    }

    public E get(int index){
        return (E)elementData[index];
    }

    public int size(){
        return size;
    }

    public E set(int index, E element){
        E oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }



    /**
     * 有限定通配符，匹配E或E的某个子类型，具体什么子类型是未知的<? extend E>
     * <？> 无限定通配符
     * @param c
     */
    public void addAll(DynamicArray<? extends E> c){
        for (int i = 0; i < c.size; i++) {
            add(c.get(i));
        }
    }

    public static int indexof(DynamicArray<?> arr,Object elm){
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).equals(elm)){
                return i;
            }
        }
        return -1;
    }

    public static <T> void swapInternal(DynamicArray<T> arr, int i, int j){
        T tmp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,tmp);
    }

    public static  void swap(DynamicArray<?> arr, int i, int j){
        swapInternal(arr, i, j);
    }

    public void copyTo(DynamicArray<E> dest){
        for (int i = 0; i < dest.size(); i++) {
            dest.add(get(i));
        }
    }

}
