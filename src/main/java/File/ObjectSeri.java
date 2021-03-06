package File;

import java.io.*;

/**
 * @author JYH
 * 2018/9/26 19:21
 */
public class ObjectSeri {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        A a1 = new A(123, "abc");
        String objectFile = "d:/日记.txt";

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectFile));
        objectOutputStream.writeObject(a1);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(objectFile));
        A a2 = (A)objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(a2);
    }


    private static class A implements Serializable{
        private int x;
        private String y;
        A(int x,String y){
            this.x = x;
            this.y = y;
        }


        @Override
        public String toString(){
            return "x = " + x + " " + "y = " + y;
        }
    }
}
