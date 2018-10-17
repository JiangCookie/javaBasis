package Jichu;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author JYH
 * 2018/10/17 18:58
 */
public class HashSetDemo {
    String size;
    String color;

    public HashSetDemo(String size, String color) {
        this.size = size;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        HashSetDemo that = (HashSetDemo) o;
        return Objects.equals(size, that.size) &&
                Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, color);
    }

    @Override
    public String toString() {
        return "HashSetDemo{" +
                "size='" + size + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Set<HashSetDemo> setDemos = new HashSet<>();
        setDemos.add(new HashSetDemo("1","red"));
        setDemos.add(new HashSetDemo("1","red"));
        System.out.println(setDemos);
    }
}
