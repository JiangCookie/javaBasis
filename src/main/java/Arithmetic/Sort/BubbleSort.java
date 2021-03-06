package Arithmetic.Sort;

/**
 * 冒泡排序
 * @author JYH
 * 2018/11/20 14:20
 */
public class BubbleSort {


    public  static  void bubble(int[] arrays){
        int length = arrays.length;
        //变量temp用来标记本趟排序是否发生了交换
        int temp =0;
        for (int i = length - 1; i > 0; i--) {
            for (int j = 0; j < i ; j++) {
                if(arrays[j] > arrays[j+1]){
                    int k = arrays[j];
                    arrays[j] = arrays[j+1];
                    arrays[j+1] = k;
                    //如果没发生交换，则temp的值为0，如果发生交换，则flag的值改为1
                    temp = 1;
                }
            }
            //一趟排序过程中没有发生关键字交换，则证明序列有序，排序结束
            if(temp == 0){
                return;
            }
        }
      }


    public static void main(String[] args) {
        int[] arrays ={2,5,1,3,4};
        bubble(arrays);
        for (int i : arrays) {
            System.out.println(i);
        }
    }
}
