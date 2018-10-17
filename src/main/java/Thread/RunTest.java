package Thread;

/**
 * @author JYH
 * 2018/10/8 12:25
 */
public class RunTest implements Runnable{


    @Override
    public void run() {
        System.out.println("Thread id:"+Thread.currentThread().getId());
        System.out.println("Thread name:"+Thread.currentThread().getName());
        System.out.println("Thread State:"+Thread.currentThread().getState());
        System.out.println("Thread Alive:"+Thread.currentThread().isAlive());
        System.out.println("我被执行了");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RunTest());
        thread.start();
        thread.join();

    }
}
