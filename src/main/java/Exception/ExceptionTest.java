package Exception;

/**
 * @author JYH
 * 2018/10/26 15:34
 */
public class ExceptionTest {



    public static void main(String[] args) {
        if(args.length > 1){
            System.out.println("请输入数字");
            return;
        }

        int num = Integer.parseInt(args[0]);
        System.out.println(num);
    }
}
