package Arithmetic.Sort;

/**
 * 冒泡排序
 * @author JYH
 * 2018/10/4 20:51
 */
public class BubbleSort {
    public static void getBubbleSort(int[] arr){
        int length = arr.length;
        //外层循环控制排序趟数
        for(int i = 0;i < length - 1; i ++){
            //表示本趟冒泡是否发生交换的标志
            boolean flag = false;
            //内层循环控制每一趟排序多少次
            for(int j = length-1;j > i; j --){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr [j];
                    arr[j] = temp;
                }
                flag = true;
            }
            if(flag == false){
                return;
            }
        }

    }


    public static void main(String[] args) {
        int[] array = {1,5,9,3,6};
        System.out.println("冒泡排序前：");
        for (int arr:array){
            System.out.print(arr);
        }
        System.out.println();
        getBubbleSort(array);
        System.out.println("冒泡排序后：");
        for (int arr:array){
            System.out.print(arr);
        }
    }
}
