package File;

import java.io.IOException;
import java.nio.channels.Selector;

/**
 * 异步I/O
 * @author JYH
 * 2018/9/27 9:52
 */
public class SelectorDemo {

    public static void getSelector() throws IOException {
        Selector selector = Selector.open();
    }
}
