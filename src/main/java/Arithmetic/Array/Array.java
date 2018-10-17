package Arithmetic.Array;

/**
 * @author JYH
 * 2018/9/23 8:38
 */
public class Array<E> {




    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造array
     * @param capacity
     */
    public Array(int capacity){
        data =(E[]) new Object[capacity];

        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity = 10
     */
    public Array(){
        this(10);
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }


    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }


    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     * @param e
     */
    public void addLast(E e){
        add(size, e);
    }

    /**
     * 向所有元素前添加一个新元素
     * @param e
     */
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 向数组第index中插入一个新元素e
     * @param index
     * @param e
     */
    public void add(int index, E e){

        if(index < 0 || index > size){
            throw new IllegalArgumentException("AddLast failed");
        }

        if(size == data.length){
            resize(2 * data.length);
        }



        for(int i = size -1 ;i >= index ; i --){
            data[i+1]=data[i];
        }
        data[index] = e;
        size ++;
    }


    /**
     * 修获取index索引位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }

        return data[index];
    }



    /**
     * 修改index索引位置的元素为e
     * @param index
     * @param e
     */
    void set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        for(int i = 0 ;i < size ; i ++){
            if(data[i].equals(e)){
                return true;
            }
        }

        return false;
    }

    /**
     * 查找数组中元素e所在的索引 ， 如果不存在元素e，则返回 -1
     * @param e
     * @return
     */
    public int find(E e){
        for(int i = 0 ;i < size ; i ++){
            if(data[i].equals(e)){
                return i;
            }
        }

        return -1;
    }

    /**
     * 从数组中删除index位置的元素， 返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed");
        }
        E ret = data[index];
        for(int i = index +1 ;i < size ;i ++){
            data[i - 1]=data[i];
        }
        size --;
        //loitering objects != memory leak
        data[size] = null;

        if(size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 从数组中删除第一个元素， 返回删除的元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素， 返回删除的元素
     * @return
     */
    public E removeLast(){
        return remove(size -1);
    }

    /**
     * 从数组中删除元素e
     * @param e
     */
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1){
                res.append(", ");
            }

        }
        res.append(']');
        return res.toString();
    }

    /**
     * 扩充数组
     * @param newCapacity
     */
    private void resize(int newCapacity){
        E[] newData =(E[]) new Object[newCapacity];
        for(int i = 0 ; i < size ; i ++){
            newData[i] = data[i];
        }
        data = newData;
    }


    public E getFirst(){
        return get(0);
    }

    public void swap(int i, int j){
        if(i < 0 || i >=size || j < 0 || j >= size){
            throw new IllegalArgumentException("Index is illegal.");

        }
        E t =data[i];
        data[i] = data[j];
        data[j] = t;
    }
}





















