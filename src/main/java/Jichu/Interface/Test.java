package Jichu.Interface;

import java.util.Arrays;

/**
 * @author JYH
 * 2018/10/20 11:04
 */
public class Test {
    public static void main(String[] args) {
        Point[] points = new Point[]{
                new Point(2,3),new Point(3,4),new Point(1,2)
        };
        System.out.println("max:" + CompUtil.max(points));
        CompUtil.sort(points);
        System.out.println(Arrays.toString(points));
    }
}
