package Thread;

/**
 * @author JYH
 * 2018/9/20 9:02
 */
public class InterruptExample extends Thread{

    @Override
    public void run() {
        while (!isInterrupted()) {
            System.out.println("循环多线程");
        }
        System.out.println("Thread end");
        String str="gfgfgfg";
        String[] str1=str.split("");
    }

//    public static void main(String[] args) {
//        InterruptExample interruptExample = new InterruptExample();
//        interruptExample.start();
//        interruptExample.interrupt();
//    }

}
