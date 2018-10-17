package Arithmetic.Queue;

/**
 * @author JYH
 * 2018/9/21 11:13
 */
public class LoopQueue<E> implements Queue<E>{
    private E[] data;
    private int front,tail;
    private int size;

    public LoopQueue(int capacity){
        data =(E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapcity(){
        return data.length - 1;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return front == tail;
    }

    public void enqueue(E e) {
        if((tail + 1) % data.length == front){
            resize(getCapcity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        if(size == getCapcity() / 4 && getCapcity() / 2 != 0 ){
            resize(getCapcity() / 2);
        }
        return ret;
    }

    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        return data[front];
    }


    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity +1];

        for(int i = 0 ; i < size ; i ++){
            newData[i] = data[(i + front) % data.length];
        }


        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, data.length));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail){
                res.append(", ");
            }

        }
        res.append("] tail");
        return res.toString();
    }
}
