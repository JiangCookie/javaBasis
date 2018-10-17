package Arithmetic.LinkedList;

/**
 * @author JYH
 * 2018/9/22 11:28
 */
public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;


        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e ,null);
        }

        public Node(){
            this(null ,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head;
    int size;

    public LinkedList(){
        head = null;
        size = 0;
    }


    /**
     * 获取链表中的元素个数
     */
    public int getSize(){
        return size;
    }

    /**
     * 链表是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在链表头添加新的元素
     */
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        head = new Node(e, head);
        size ++;
    }

    /**
     * 在链表的index（0-based）位置添加新元素e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add faied. Illegal index");
        }

        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            for(int i = 0;i<index -1;i++){
                prev = prev.next;
            }
            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;


            size++;
        }
    }

    /**
     * 在链表末尾添加新的元素e
     */
    public void addLast(E e){
        add(size , e);
    }

    /**
     * 获得链表的第index（0-based）个位置的元素
     */
    public E get(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add faied. Illegal index");
        }

        Node cur = head;
        for(int i =0 ; i < index -1 ; i ++){
            cur = cur.next;
        }

        return  cur.e;
    }


    /**
     * 查找链表中是否有元素e
     */
    public  boolean contains(E e){
        Node cur = head ;
        while(cur != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }

        return  false;
    }


    /**
     * 从链表中删除index位置的元素，返回删除的元素
     */
    public E romove(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add faied. Illegal index");
        }

        Node prev = head;
        for(int i = 0; i< index -1 ;i++){
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;

        return  retNode.e;
    }

}


































