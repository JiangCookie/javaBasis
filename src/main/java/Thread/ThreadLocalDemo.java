package Thread;

/**
 * @author JYH
 * 2018/11/26 16:33
 */
public class ThreadLocalDemo{
    private static ThreadLocal<Integer> local = new ThreadLocal<Integer>(){

        @Override
        protected Integer initialValue() {
            return 100;
        }
    };

    public static void main(String[] args) {
        System.out.println(local.get());
        local.set(200);
        local.remove();
        System.out.println(local.get());
    }
}
