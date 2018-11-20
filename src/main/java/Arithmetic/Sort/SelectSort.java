package Arithmetic.Sort;

/**
 * 选择排序
 * @author JYH
 * 2018/11/20 21:22
 */
public class SelectSort {

    public static void sSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int k = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[k] > arr[j]){
                    k = j;
                }
            }
            int temp = arr[k];
            arr[k] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {49,38,65,97,76,13,27};
        int length = arr.length;
        sSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
