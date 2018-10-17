package Jichu;

import java.util.*;

/**
 * @author JYH
 * 2018/10/17 9:46
 */
public class LinkedListTest {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("a");
        while (queue.peek() != null){
            System.out.println(queue.poll());
        }

        Deque<String> stack = new LinkedList<>();
        stack.push("aa");
        while (stack.peek() != null){
            System.out.println(stack.pop());
        }

        List<String> list = new ArrayList<>();
        list.add("dd");
    }
}
