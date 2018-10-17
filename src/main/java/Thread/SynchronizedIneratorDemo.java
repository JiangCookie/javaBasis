package Thread;

import java.util.*;

/**
 * 同步容器，单个操作是安全的，但迭代不是。创建一个同步list 对象，一个线程修改list ，另一个遍历
 * 结果：遍历容器的同时发生结构性变化。会抛出异常。如果要避免这个异常，需要在遍历的时候给整个容器对象加锁
 * @author JYH
 * 2018/10/9 18:30
 */
public class SynchronizedIneratorDemo {
    private static void startModifyThread(final List<String> list){
        Thread modifyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    list.add("item" + i);
                    try {
                        Thread.sleep((int)(Math.random() * 10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        modifyThread.start();

    }

    private static void startIteratorThread(final List<String> list){
        Thread iteratorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    for (String str : list) {

                    }
                }
//                synchronized (list){
//                    for (String str : list) {
//
//                    }
//                }
            }
        });
        iteratorThread.start();

    }

    public static void main(String[] args) {
        final List<String> list = Collections.synchronizedList(new ArrayList<String>());
        startModifyThread(list);
        startIteratorThread(list);


    }
}
