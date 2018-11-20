package Arithmetic.Sort;

/**
 * 快速排序
 * @author JYH
 * 2018/11/20 16:11
 */
public class QuickSort {

    public  static  void qSort(int[] arr, int low, int high){
        int i = low;
        int j = high;
        int temp = arr[low];
        while(i<j){

            while (j>i && temp < arr[j]){
                j--;
            }
            if(i<j){
                arr[i] = arr[j];
                i ++;
            }
            while (i<j && temp > arr[i]){
                i++;
            }
            if(i<j){
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = temp;
        if(low < j){
            qSort(arr,low,j-1);
        }
        if(high > i){
            qSort(arr,j+1,high);
        }



    }

    public static void main(String[] args) {
        int[] arr = {49,38,65,97,76,13,27};
        int length = arr.length;
        qSort(arr, 0, length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
