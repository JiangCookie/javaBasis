package Thread.ProducerAndConsumer;


import sun.misc.Unsafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JYH
 * 2018/10/10 21:54
 */
public class MyBlockingQueue<E> {
    private Queue<E> queue = null;
    private int limit;
    public MyBlockingQueue(int limit){
        this.limit = limit;
        queue = new LinkedList<>();
    }

    public synchronized void put(E e) throws InterruptedException {
        while (queue.size() == limit){
            wait();
        }
        queue.add(e);
        notifyAll();
    }

    public synchronized E take() throws InterruptedException {
        while (queue.isEmpty()){
            wait();
        }
        E e = queue.poll();
        notifyAll();
        return e;
    }

    static class Producer extends Thread{
        MyBlockingQueue<String> queue;
        public Producer(MyBlockingQueue<String> queue){
            this.queue = queue;
        }

        @Override
        public void run(){
            int num = 0;
            try{
                while (true){
                    String data =String.valueOf(num);
                    queue.put(data);
                    System.out.println("produce task" + data);
                    num ++ ;
                    Thread.sleep((int)(Math.random()* 100));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    static class Consumer extends Thread{
        MyBlockingQueue<String> queue;
        public Consumer(MyBlockingQueue<String> queue){
            this.queue = queue;
        }

        @Override
        public void run(){
            int num = 0;
            try{
                while (true){
                    String data =queue.take();
                    System.out.println("handle task" + data);
                    Thread.sleep((int)(Math.random()* 100));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyBlockingQueue<String> myBlockingQueue = new MyBlockingQueue<>(10);
        new Producer(myBlockingQueue).start();
        new Consumer(myBlockingQueue).start();

    }
}
