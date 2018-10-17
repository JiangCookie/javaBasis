package Arithmetic.Queue;

import Arithmetic.Array.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author JYH
 * 2018/9/21 11:38
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<E>(capacity);
    }

    public ArrayQueue(){
        array = new Array<E>();
    }


    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    public void enqueue(E e) {
        array.addLast(e);
    }

    public E dequeue() {
        return array.removeFirst();
    }

    public E getFront() {
        return array.getFirst();
    }


    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front  [ ");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array);
            if(i !=array.getSize() - 1){
                res.append(", ");
            }

        }
        res.append("] tail");
        return res.toString();
    }
}
