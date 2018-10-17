package Thread;

/**
 * @author JYH
 * 2018/10/8 16:27
 */
public class SynchronizedTest extends Thread{
    Counter counter;
    public SynchronizedTest(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        for (int i = 0; i < 1000; i ++){
            counter.incr();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 1000;

//        Thread[] threads = new  Thread[num];
//        for(int i = 0; i < num; i ++){
//            threads[i] = new SynchronizedTest(counter);
//            threads[i].start();
//        }
//
//        for (int i = 0; i < num; i++) {
//            threads[i].join();
//        }
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Thread thread1 = new SynchronizedTest(counter1);
        Thread thread2 = new SynchronizedTest(counter2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter1.getCount());
        System.out.println(counter2.getCount());
    }
}
