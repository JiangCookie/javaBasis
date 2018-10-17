package Thread;

/**
 * @author JYH
 * 2018/10/8 16:28
 */
public class Counter {
        private int count;
//    public  void incr(){
//        synchronized (this){
//            count ++;
//        }
//
//    }
//    public int getCount(){
//        synchronized (this){
//            return count;
//        }
//
//    }
//public  void incr(){
//    synchronized (Counter.class){
//        count ++;
//    }
//
//}
//    public int getCount(){
//        synchronized (Counter.class){
//            return count;
//        }
//
//    }
    private Object lock = new Object();
public  void incr(){
        synchronized (lock){
            count ++;
        }

    }
    public int getCount(){
        synchronized (lock){
            return count;
        }

    }
}
