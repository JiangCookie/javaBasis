package Arithmetic.Sort;

/**
 * 快速排序
 * @author JYH
 * 2018/10/5 15:55
 */
public class Qsort {
    public static int[] getQsort(int[] array){
        if(array.length < 2){
            return array;
        }else{
            int pivot = array[0];
            for (int i = array.length -1;i > 0; i --){
                if(pivot > array[i]){

                }
            }
            return array;
        }

    }

    public static void main(String[] args) {
        int[] array = {5,9,3,6};
        System.out.println("快速排序前：");
        for (int arr:array){
            System.out.print(arr);
        }
        System.out.println();
        getQsort(array);
        System.out.println("快速排序后：");
        for (int arr:array){
            System.out.print(arr);
        }
    }
}
