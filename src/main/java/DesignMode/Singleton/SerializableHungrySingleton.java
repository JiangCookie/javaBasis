package DesignMode.Singleton;

import java.io.*;

/**
 * 单例设计模式-序列化破坏单例模式原理
 * @author JYH
 * 2018/11/21 21:18
 */
public class SerializableHungrySingleton implements Serializable{
    private final static SerializableHungrySingleton serializableHungrySingleton = new SerializableHungrySingleton();
    private SerializableHungrySingleton(){

    }
    public static SerializableHungrySingleton getInstance(){
        return serializableHungrySingleton;
    }

    private Object readResolve(){
        return serializableHungrySingleton;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializableHungrySingleton instance = SerializableHungrySingleton.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
        oos.writeObject(instance);

        File file = new File("singleton_file");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        SerializableHungrySingleton newInstance = (SerializableHungrySingleton) ois.readObject();

    }
}
