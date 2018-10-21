package Lambda;

/**
 * @author JYH
 * 2018/10/20 20:27
 */
public class Test extends Thread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread");
            }
        });
    }

}
