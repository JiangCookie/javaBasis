package Arrays;

/**
 * @author JYH
 * 2018/12/5 21:10
 */
public class GcTest {
    private Object instance = null;
    private static final int _1MB = 1024 * 1024;

    /** 这个成员属性唯一的作用就是占用一点内存 */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args)
    {

    }
}
