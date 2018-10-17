package Jichu;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * 实现我们自己的哈希表
 * @author JYH
 * 2018/10/7 15:49
 */
public class HashTable<K, V> {
    private TreeMap<K, V>[] hashtable;
    private int M;
    private int size;

    public HashTable(int M){
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i ++){
            hashtable[i] = new TreeMap<>();
        }
    }

    public HashTable(){
        this(97);
    }

    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize(){
        return size;
    }

    public void add(K key,V value){
        if(hashtable[hash(key)].containsKey(key)){


        }

    }
}
